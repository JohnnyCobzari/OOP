package Lab3;
public class CarStation {
    private final Dineable diningService;
    private final Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        if (!queue.isFull()) {
            queue.enqueue(car); // Adds a car to the queue
            System.out.println("Car " + car.getId() + " added to the queue.");
        } else {
            System.out.println("Cannot add car " + car.getId() + ". The queue is full.");
        }
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue(); // Removes the next car from the queue
            System.out.println("Car " + car.getId() + " is served.");
            // Serve dinner if the car's passengers want it
            if (car.isWantsDinner()) {
                diningService.serveDinner(car.getId());
            }

            // Refuel the car
            refuelingService.refuel(car.getId(), car.getConsumption());
        }
    }
}
