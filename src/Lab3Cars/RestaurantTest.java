package Lab3Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    private Dineable peopleDinner1;
    private Dineable peopleDinner2;
    private Dineable robotDinner;
    private Refuelable gasStation1;
    private Refuelable gasStation2;
    private Refuelable electricStation;

    public static void displayCounts() {
        System.out.println();
        System.out.println("People served: " + PeopleDinner.getPeopleServed());
        System.out.println("Robots served: " + RobotDinner.getRobotsServed());
        System.out.println("Gas cars refueled: " + GasStation.getGasCarsServed());
        System.out.println("Electric cars refueled: " + ElectricStation.getElectricCarsServed());
    }

    @BeforeEach
    public void setUp() {
        peopleDinner1 = new PeopleDinner();
        peopleDinner2 = new PeopleDinner();
        robotDinner = new RobotDinner();
        gasStation1 = new GasStation();
        gasStation2 = new GasStation();
        electricStation = new ElectricStation();

    }

    @Test
    public void testServeDinner() {
        peopleDinner1.serveDinner(1);
        peopleDinner2.serveDinner(2);
        robotDinner.serveDinner(3);

        System.out.println();
        assertEquals(2, PeopleDinner.getPeopleServed());
        assertEquals(1, RobotDinner.getRobotsServed());
    }

    @Test
    public void testRefuel() {
        gasStation1.refuel(4,20);
        gasStation2.refuel(5,20);
        electricStation.refuel(6,20);
        electricStation.refuel(7,20);

        System.out.println();
        assertEquals(2, GasStation.getGasCarsServed());
        assertEquals(2, ElectricStation.getElectricCarsServed());
    }

    @Test
    public void testGlobalTracking() {
        // Serve some cars
        peopleDinner1.serveDinner(1);
        peopleDinner2.serveDinner(1);
        robotDinner.serveDinner(3);
        gasStation1.refuel(4,20);
        gasStation2.refuel(5,20);
        electricStation.refuel(6,20);
        electricStation.refuel(7,20);

        System.out.println();
        assertEquals(2, PeopleDinner.getPeopleServed(), "Total people served should be 2");
        assertEquals(1, RobotDinner.getRobotsServed(), "Total robots served should be 1");
        assertEquals(2, GasStation.getGasCarsServed(), "Total gas cars served should be 2");
        assertEquals(2, ElectricStation.getElectricCarsServed(), "Total electric cars served should be 2");
        assertEquals(2, PeopleDinner.getPeopleServed());
        assertEquals(1, RobotDinner.getRobotsServed());
        assertEquals(2, GasStation.getGasCarsServed());
        assertEquals(2, ElectricStation.getElectricCarsServed());

        displayCounts();
    }

    @Test
    public void testSkipDining() {
        // Simulate cars that don't want to dine
        gasStation1.refuel(8,20);
        gasStation2.refuel(9,20);
        electricStation.refuel(10,20);
        electricStation.refuel(11,20);

        System.out.println();
        // Ensure dining counts are not incremented
        assertEquals(0, PeopleDinner.getPeopleServed(), "\nNo people should have been served");
        assertEquals(0, RobotDinner.getRobotsServed(), "No robots should have been served");

        // Verify refuel counts
        assertEquals(2, GasStation.getGasCarsServed(), "Total gas cars served should be 2");
        assertEquals(2, ElectricStation.getElectricCarsServed(), "Total electric cars served should be 2");
    }
}