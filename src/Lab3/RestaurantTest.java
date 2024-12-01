package Lab3;

public class RestaurantTest {
    public static void main(String[] args) {
        // Dineable examples
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();

        peopleDinner.serveDinner("John");
        peopleDinner.serveDinner("Jane");
        robotDinner.serveDinner("RobotX");
        robotDinner.serveDinner("RobotY");

        // Refuelable examples
        Refuelable electricStation1 = new ElectricStation();
        Refuelable electricStation2 = new ElectricStation(); // Counts together with station 1
        Refuelable gasStation = new GasStation();

        electricStation1.refuel("Car1",10);
        electricStation2.refuel("Car2",10);
        gasStation.refuel("Car3",10);
        gasStation.refuel("Car4",10);

        // Print summary counts
        System.out.println("\nSummary:");
        System.out.println("People served: " + PeopleDinner.getPeopleCount());
        System.out.println("Robots served: " + RobotDinner.getRobotCount());
        System.out.println("Electric cars refueled: " + ElectricStation.getElectricCarCount());
        System.out.println("Gas cars refueled: " + GasStation.getGasCarCount());
    }
}
