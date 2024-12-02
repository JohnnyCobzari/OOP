package Lab3;

public class CarStationTest {
    public static void main(String[] args) {
        // Example implementations of Dineable and Refuelable
        Dineable peopleDinner = new PeopleDinner();
        Refuelable gasStation = new GasStation();

        // Example queue implementation with a capacity of 2
        Queue<Car> carQueue = new ArrayQueue<>(3);

        // Create a CarStation
        CarStation carStation = new CarStation(peopleDinner, gasStation, carQueue);

        // Add cars to the station
        carStation.addCar(new Car("Car1", "GAS", "PEOPLE", true, 40));
        carStation.addCar(new Car("Car2", "GAS", "ROBOTS", false, 30));
        carStation.addCar(new Car("Car3", "ELECTRIC", "PEOPLE", true, 20)); // This should fail

        // Serve all cars
        carStation.serveCars();
    }
}
