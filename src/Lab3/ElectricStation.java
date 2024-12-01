package Lab3;

public class ElectricStation implements Refuelable {
    private static int electricCarCount = 0;

    @Override
    public void refuel(String carId, int consumption) {
        electricCarCount++;
        System.out.println("Refueling electric car " + carId + " with " + consumption);
    }

    public static int getElectricCarCount() {
        return electricCarCount;
    }
}
