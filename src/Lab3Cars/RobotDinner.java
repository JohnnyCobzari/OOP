package Lab3Cars;

public class RobotDinner implements Dineable{
    private static int robotsServed = 0;
    private static int totalRobots = 0;

    @Override
    public void serveDinner(int carId) {
        robotsServed++;
        System.out.println("Serving dinner to ROBOTS in car: " + carId);
    }

    public static void countRobot(){
        totalRobots++;
    }

    public static int getRobotsServed() {
        return robotsServed;
    }

    public static int getTotalRobots() {
        return totalRobots;
    }

    public static void resetRobotsServed() {
        robotsServed = 0;
        totalRobots = 0;
    }

}