package Lab3Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestSemaphore {

    private Semaphore semaphore;

    @BeforeEach
    public void setUp() {
        CarStation gasPeopleStation = new CarStation(
                new PeopleDinner(),
                new GasStation(),
                new LinkedQueue<>(10)
        );

        CarStation gasRobotStation = new CarStation(
                new RobotDinner(),
                new GasStation(),
                new LinkedQueue<>(10)
        );

        CarStation electricPeopleStation = new CarStation(
                new PeopleDinner(),
                new ElectricStation(),
                new LinkedQueue<>(10)
        );

        CarStation electricRobotStation = new CarStation(
                new RobotDinner(),
                new ElectricStation(),
                new LinkedQueue<>(10)
        );

        semaphore = new Semaphore(gasPeopleStation, gasRobotStation, electricPeopleStation, electricRobotStation);
    }

    @Test
    public void testRouteCar() {
        semaphore.routeCar(new Car(1, "GAS", "PEOPLE", true, 10));
        semaphore.routeCar(new Car(2, "GAS", "ROBOTS", false, 20));
        semaphore.routeCar(new Car(3, "ELECTRIC", "PEOPLE", true, 30));
        semaphore.routeCar(new Car(4, "ELECTRIC", "ROBOTS", false, 40));

        Map<String, Integer> stats = semaphore.getStats();
        assertEquals(2, stats.get("GAS Cars served"), "Two GAS cars should have been routed");
        assertEquals(2, stats.get("ELECTRIC Cars served"), "Two ELECTRIC cars should have been routed");
        assertEquals(2, stats.get("PEOPLE Total"), "Two PEOPLE cars should have been routed");
        assertEquals(2, stats.get("ROBOTS Total"), "Two ROBOTS cars should have been routed");
    }

    @Test
    public void testServeAllCars() {
        semaphore.routeCar(new Car(5, "GAS", "PEOPLE", true, 10));
        semaphore.routeCar(new Car(6, "ELECTRIC", "ROBOTS", true, 15));
        semaphore.routeCar(new Car(7, "GAS", "ROBOTS", false, 20));
        semaphore.routeCar(new Car(8, "ELECTRIC", "PEOPLE", true, 25));

        semaphore.serveAllCars();

        Map<String, Integer> stats = semaphore.getStats();
        assertEquals(3, stats.get("DINING cars"), "All dining cars should have been served");
        assertEquals(1, stats.get("NON-DINING cars"), "All non-dining cars should have been served");
    }

    @Test
    public void testGetStats() {
        semaphore.routeCar(new Car(13, "GAS", "PEOPLE", true, 10));
        semaphore.routeCar(new Car(14, "GAS", "ROBOTS", true, 15));
        semaphore.routeCar(new Car(15, "ELECTRIC", "PEOPLE", false, 20));
        semaphore.routeCar(new Car(16, "ELECTRIC", "ROBOTS", false, 25));

        Map<String, Integer> stats = semaphore.getStats();
        assertEquals(2, stats.get("GAS Cars served"), "Two GAS cars should have been routed");
        assertEquals(2, stats.get("ELECTRIC Cars served"), "Two ELECTRIC cars should have been routed");
        assertEquals(2, stats.get("PEOPLE Total"), "Two PEOPLE cars should have been routed");
        assertEquals(2, stats.get("ROBOTS Total"), "Two ROBOTS cars should have been routed");
        assertEquals(2, stats.get("DINING cars"), "Two cars should have requested dining");
        assertEquals(2, stats.get("NON-DINING cars"), "Two cars should not have requested dining");
    }

    @Test
    public void testNoCars() {
        semaphore.serveAllCars();

        Map<String, Integer> stats = semaphore.getStats();
        assertEquals(0, stats.get("GAS Cars served"), "No GAS cars should have been served");
        assertEquals(0, stats.get("ELECTRIC Cars served"), "No ELECTRIC cars should have been served");
        assertEquals(0, stats.get("PEOPLE Total"), "No PEOPLE cars should have been served");
        assertEquals(0, stats.get("ROBOTS Total"), "No ROBOTS cars should have been served");
        assertEquals(0, stats.get("DINING cars"), "No dining cars should have been served");
        assertEquals(0, stats.get("NON-DINING cars"), "No non-dining cars should have been served");
    }
}