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

            if ("PEOPLE".equals(car.getPassengerType())) {
                PeopleDinner.countPeople();
            } else if ("ROBOTS".equals(car.getPassengerType())) {
                RobotDinner.countRobot();
            } else {
                System.err.println("Unknown passenger type for car ID: " + car.getId());
            }

            if (car.isWantsDinner()) {
                diningService.serveDinner(car.getId());
            }
            refuelingService.refuel(car.getId(), car.getConsumption());
        }
    }
}