package Lab3Cars;

public class PeopleDinner implements Dineable {
    private static int peopleServed = 0;
    private static int totalPeople = 0;

    public static String getPeopleServed() {
        return peopleServed + "";
    }

    @Override
    public void serveDinner(int carId) {
        peopleServed++;
        System.out.println("Serving dinner to PEOPLE in car: " + carId);
    }


}