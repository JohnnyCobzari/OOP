package Lab3Cars;


import java.util.HashMap;
import java.util.Map;

public class Semaphore {

    private final CarStation gasPeopleStation;
    private final CarStation gasRobotStation;
    private final CarStation electricPeopleStation;
    private final CarStation electricRobotStation;

    private final Map<String, Integer> carTypeCount = new HashMap<>();
    private final Map<String, Integer> passengerTypeCount = new HashMap<>();
    private int diningCount = 0;
    private int nonDiningCount = 0;

    public Semaphore(CarStation gasPeopleStation, CarStation gasRobotStation,
                     CarStation electricPeopleStation, CarStation electricRobotStation) {
        this.gasPeopleStation = gasPeopleStation;
        this.gasRobotStation = gasRobotStation;
        this.electricPeopleStation = electricPeopleStation;
        this.electricRobotStation = electricRobotStation;

        carTypeCount.put("GAS", 0);
        carTypeCount.put("ELECTRIC", 0);
        passengerTypeCount.put("PEOPLE", 0);
        passengerTypeCount.put("ROBOTS", 0);
    }

    public void routeCar(Car car) {
        String type = car.getType();
        String passengerType = car.getPassengerType();

        if ("GAS".equals(type)) {
            if ("PEOPLE".equals(passengerType)) {
                gasPeopleStation.addCar(car);
                carTypeCount.put("GAS", carTypeCount.get("GAS") + 1);
                passengerTypeCount.put("PEOPLE", passengerTypeCount.get("PEOPLE") + 1);
            } else if ("ROBOTS".equals(passengerType)) {
                gasRobotStation.addCar(car);
                carTypeCount.put("GAS", carTypeCount.get("GAS") + 1);
                passengerTypeCount.put("ROBOTS", passengerTypeCount.get("ROBOTS") + 1);
            }
        } else if ("ELECTRIC".equals(type)) {
            if ("PEOPLE".equals(passengerType)) {
                electricPeopleStation.addCar(car);
                carTypeCount.put("ELECTRIC", carTypeCount.get("ELECTRIC") + 1);
                passengerTypeCount.put("PEOPLE", passengerTypeCount.get("PEOPLE") + 1);
            } else if ("ROBOTS".equals(passengerType)) {
                electricRobotStation.addCar(car);
                carTypeCount.put("ELECTRIC", carTypeCount.get("ELECTRIC") + 1);
                passengerTypeCount.put("ROBOTS", passengerTypeCount.get("ROBOTS") + 1);
            }
        } else {
            System.err.println("Unknown car type: " + car);
        }

        if (car.isWantsDinner()) {
            diningCount++;
        } else {
            nonDiningCount++;
        }
    }

    public void serveAllCars() {
        gasPeopleStation.serveCars();
        gasRobotStation.serveCars();
        electricPeopleStation.serveCars();
        electricRobotStation.serveCars();
    }

    public Map<String, Integer> getStats() {
        Map<String, Integer> resultStats = new HashMap<>();
        resultStats.put("GAS Cars served", carTypeCount.getOrDefault("GAS", 0));
        resultStats.put("ELECTRIC Cars served", carTypeCount.getOrDefault("ELECTRIC", 0));
        resultStats.put("PEOPLE Total", passengerTypeCount.getOrDefault("PEOPLE", 0));
        resultStats.put("ROBOTS Total", passengerTypeCount.getOrDefault("ROBOTS", 0));
        resultStats.put("DINING cars", diningCount);
        resultStats.put("NON-DINING cars", nonDiningCount);
        resultStats.put("ELECTRIC_C",ElectricStation.getElectricConsumption());
        resultStats.put("GAS_C",GasStation.getGasConsumption());
        return resultStats;
    }
}