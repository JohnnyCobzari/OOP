package Lab3Cars;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final String queueDirectory;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ScheduledExecutorService pollingExecutor = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService servingExecutor = Executors.newSingleThreadScheduledExecutor();

    private final CarStation gasPeopleStation;
    private final CarStation gasRobotStation;
    private final CarStation electricPeopleStation;
    private final CarStation electricRobotStation;

    private final Semaphore semaphore;

    public Scheduler(String queueDirectory) {
        this.queueDirectory = queueDirectory;

        this.gasPeopleStation = new CarStation(
                new PeopleDinner(),
                new GasStation(),
                new LinkedQueue<>(30)
        );

        this.gasRobotStation = new CarStation(
                new RobotDinner(),
                new GasStation(),
                new ArrayQueue<>(30)
        );

        this.electricPeopleStation = new CarStation(
                new PeopleDinner(),
                new ElectricStation(),
                new LinkedQueue<>(30)
        );

        this.electricRobotStation = new CarStation(
                new RobotDinner(),
                new ElectricStation(),
                new ArrayQueue<>(30)
        );

        semaphore = new Semaphore(gasPeopleStation, gasRobotStation, electricPeopleStation, electricRobotStation);
    }

    private void pollQueueDirectory() {
        File directory = new File(queueDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid queue directory: " + queueDirectory);
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));
        if (files != null) {
            for (File file : files) {
                try {
                    Car car = objectMapper.readValue(file, Car.class);
                    semaphore.routeCar(car);
//                    System.out.println("Processed car ID: " + car.getId());
                    Files.delete(Paths.get(file.getPath()));

                    if (car.getId() == 30) {
//                        System.out.println("30 cars processed. Completing remaining tasks...");
                        shutdown();
                        return;
                    }
                } catch (Exception e) {
                    System.err.println("Error processing file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    public void polling(int intervalSeconds) {
        pollingExecutor.scheduleAtFixedRate(this::pollQueueDirectory, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    public void serving(int intervalSeconds) {
        servingExecutor.scheduleAtFixedRate(() -> {
            System.out.println("\n🚗 Serving cars 🚗");
            semaphore.serveAllCars();
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    public void shutdown() {
        try {
//            System.out.println("Shutting down scheduler...");
            pollingExecutor.shutdown();
            servingExecutor.shutdown();

            if (!pollingExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                pollingExecutor.shutdownNow();
            }
            if (!servingExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                servingExecutor.shutdownNow();
            }

//            System.out.println("Serving all remaining cars...");
            gasPeopleStation.serveCars();
            gasRobotStation.serveCars();
            electricPeopleStation.serveCars();
            electricRobotStation.serveCars();

            printStats();

//            System.out.println("Scheduler shut down successfully.");
        } catch (InterruptedException e) {
            System.err.println("Error during shutdown. Forcing termination...");
            pollingExecutor.shutdownNow();
            servingExecutor.shutdownNow();
        }
    }

    public void printStats() {
        Map<String, Integer> stats = semaphore.getStats();
        String statsString = String.format(
                "{ \"ELECTRIC\": %d, \"GAS\": %d, \"PEOPLE\": %d, \"ROBOTS\": %d, \"DINING\": %d, \"NOT_DINING\": %d, " +
                        "\"CONSUMPTION\": { \"ELECTRIC\": %d, \"GAS\": %d } }",
                stats.get("ELECTRIC Cars served"),
                stats.get("GAS Cars served"),
                stats.get("PEOPLE Total"),
                stats.get("ROBOTS Total"),
                stats.get("DINING cars"),
                stats.get("NON-DINING cars"),
                ElectricStation.getElectricConsumption(),
                GasStation.getGasConsumption()
        );

        System.out.println();
        System.out.println(statsString);
    }
}