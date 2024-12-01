package Lab3;

public class PeopleDinner implements Dineable {
    private static int peopleCount = 0;

    @Override
    public void serveDinner(String carId) {
        peopleCount++;
        System.out.println("Serving dinner to person " + carId + ".");
    }

    public static int getPeopleCount() {
        return peopleCount;
    }
}