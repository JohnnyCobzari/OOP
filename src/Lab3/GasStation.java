package Lab3;

public class GasStation implements Refuelable {
    private static int gasCarCount = 0;

    @Override
    public void refuel(String carId, int consumption) {
        gasCarCount++;
        System.out.println("Refueling gas car " + carId + " with "+ consumption + " consumption");
    }

    public static int getGasCarCount() {
        return gasCarCount;
    }
}
