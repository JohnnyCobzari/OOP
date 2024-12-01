package Lab3;

public class ElectricStation implements Refuelable {
    private static int electricCarCount = 0;

    @Override
    public void refuel(String carId) {
        electricCarCount++;
        System.out.println("Refueling electric car " + carId + ".");
    }

    public static int getElectricCarCount() {
        return electricCarCount;
    }
}
