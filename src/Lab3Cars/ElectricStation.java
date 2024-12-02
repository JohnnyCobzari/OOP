package Lab3Cars;

public class ElectricStation implements Refuelable{
    private static int electricCarsServed = 0;
    private static int electricConsumption = 0;

    @Override
    public void refuel(int carId, int consumption) {
        electricCarsServed++;
        electricConsumption += consumption;
        System.out.println("Refueling ELECTRIC car: " + carId);
    }

    public static int getElectricCarsServed() {
        return electricCarsServed;
    }

    public static int getElectricConsumption() {
        return electricConsumption;
    }

    public static void resetElectricCarsServed() {
        electricCarsServed = 0;
        electricConsumption = 0;
    }

}