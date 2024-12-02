package Lab3;

public class RobotDinner implements Dineable {
    private static int robotCount = 0;

    @Override
    public void serveDinner(String carId) {
        robotCount++;
        System.out.println("Serving dinner to robot " + carId + ".");
    }

    public static int getRobotCount() {
        return robotCount;
    }
}
