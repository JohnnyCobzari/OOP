package Lab3Cars;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();

            if (car.isWantsDinner()) {
                diningService.serveDinner(car.getId());
            }
            refuelingService.refuel(car.getId(), car.getConsumption());
        }
    }
}