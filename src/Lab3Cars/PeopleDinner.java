package Lab3Cars;

public class PeopleDinner implements Dineable {
    private static int peopleServed = 0;
    private static int totalPeople = 0;

    @Override
    public void serveDinner(int carId) {
        peopleServed++;
        System.out.println("Serving dinner to PEOPLE in car: " + carId);
    }

    public static void countPeople(){
        totalPeople ++;
    }

    public static int getTotalPeople() {
        return totalPeople;
    }

    public static int getPeopleServed(){
        return peopleServed;
    }

    public static void resetPeopleServed() {
        peopleServed = 0;
        totalPeople = 0;
    }
}