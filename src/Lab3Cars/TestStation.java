package Lab3Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStation {

    private Queue<Car> carQueue;
    private CarStation carStation;

    @BeforeEach
    public void setUp() {
        carQueue = new LinkedQueue<>(5);

        Dineable diningService = carId -> System.out.println("Serving dinner to: " + carId);
        Refuelable refuelingService = (carId,consumption) -> System.out.println("Refueling: " + carId);

        carStation = new CarStation(diningService, refuelingService, carQueue);
    }

    @Test
    public void testAddCar() {
        Car car = new Car(1,"GAS", "PEOPLE", true,10); // Updated
        carStation.addCar(car);

        assertFalse(carQueue.isEmpty());
        assertEquals(1, carQueue.size());
        assertEquals(car, carQueue.peek());
    }

    @Test
    public void testServeCars() {
        carStation.addCar(new Car(2,"GAS", "PEOPLE", true,12));       // Wants dinner
        carStation.addCar(new Car(3,"ELECTRIC", "ROBOTS", false,10)); // No dinner

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testAllCarsWantDinner() {
        // Add cars that all want dinner
        carStation.addCar(new Car(4,"GAS", "PEOPLE", true,10));
        carStation.addCar(new Car(5,"ELECTRIC", "ROBOTS", true,10));
        carStation.addCar(new Car(6,"GAS", "ROBOTS", true,10));

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testNoCarsWantDinner() {
        carStation.addCar(new Car(7,"GAS", "PEOPLE", false,10));
        carStation.addCar(new Car(8,"ELECTRIC", "ROBOTS", false,10));

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testServeEmptyQueue() {
        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should remain empty when there are no cars to serve");
    }

    @Test
    public void testServeLargeNumberOfCars() {
        for (int i = 1; i <= 5; i++) {
            carStation.addCar(new Car(9,"GAS", "PEOPLE", i % 2 == 0,10)); // Alternate dinner requests
        }

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testMixedCars() {
        carStation.addCar(new Car(10,"GAS", "PEOPLE", true,10));       // Wants dinner
        carStation.addCar(new Car(11,"ELECTRIC", "ROBOTS", false,10)); // No dinner
        carStation.addCar(new Car(12,"GAS", "ROBOTS", false,10));      // No dinner
        carStation.addCar(new Car(13,"ELECTRIC", "PEOPLE", true,10));  // Wants dinner

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testQueueOverflow() {
        for (int i = 1; i <= 5; i++) {
            carStation.addCar(new Car(14,"GAS", "PEOPLE", false,10));
        }

        assertThrows(IllegalStateException.class, () -> carStation.addCar(new Car(15,"ELECTRIC", "ROBOTS", true,10)),
                "Adding a car to a full queue should throw an exception");
    }
}