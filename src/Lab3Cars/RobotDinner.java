package Lab3Cars;

public class RobotDinner implements Dineable{
    private static int robotsServed = 0;

    public static String getRobotsServed() {
        return Integer.toString(robotsServed);
    }


    @Override
    public void serveDinner(int carId) {
        robotsServed++;
        System.out.println("Serving dinner to ROBOTS in car: " + carId);
    }

}