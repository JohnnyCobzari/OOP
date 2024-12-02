package Lab3Cars;

public class GasStation implements Refuelable {
    private static int gasCarsServed = 0;
    private static int gasConsumption = 0;

    public static int getGasCarsServed() {
        return gasCarsServed;
    }

    @Override
    public void refuel(int carId, int consumption) {
        gasCarsServed++;
        gasConsumption += consumption;
        System.out.println("Refueling GAS car: " + carId);
    }
    public static int getGasConsumption() {
        return gasConsumption;
    }


}