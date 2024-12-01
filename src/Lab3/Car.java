package Lab3;

public class Car {
    private final String id;
    private final String carType; // ELECTRIC or GAS
    private final String passengerType; // PEOPLE or ROBOTS
    private final boolean wantsDinner; // true or false
    private final int consumption; // fuel consumption in liters

    public Car(String id, String carType, String passengerType, boolean wantsDinner, int consumption) {
        this.id = id;
        this.carType = carType;
        this.passengerType = passengerType;
        this.wantsDinner = wantsDinner;
        this.consumption = consumption;
    }

    public String getId() {
        return id;
    }

    public String getCarType() {
        return carType;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public boolean isWantsDinner() {
        return wantsDinner;
    }

    public int getConsumption() {
        return consumption;
    }
}
