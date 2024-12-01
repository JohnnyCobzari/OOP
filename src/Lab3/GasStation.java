package Lab3;

public class GasStation implements Refuelable {
    private static int gasCarCount = 0;

    @Override
    public void refuel(String carId) {
        gasCarCount++;
        System.out.println("Refueling gas car " + carId + ".");
    }

    public static int getGasCarCount() {
        return gasCarCount;
    }
}
