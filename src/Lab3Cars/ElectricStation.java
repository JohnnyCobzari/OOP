package Lab3Cars;

public class ElectricStation implements Refuelable{
    private static int electricCarsServed = 0;
    private static int electricConsumption = 0;

    public static int getElectricCarsServed() {
        return electricCarsServed;
    }

    @Override
    public void refuel(int carId, int consumption) {
        electricCarsServed++;
        electricConsumption += consumption;
        System.out.println("Refueling ELECTRIC car: " + carId);
    }

    public static int getElectricConsumption() {
        return electricConsumption;
    }



}