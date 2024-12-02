package Lab3Cars;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Car {
    private int id;
    private String type; // GAS or ELECTRIC
    private String passengerType; // PEOPLE or ROBOTS
    private boolean wantsDinner;
    private int consumption;

    public Car(
            @JsonProperty("id") int id,
            @JsonProperty("type") String type,
            @JsonProperty("passengers") String passengerType,
            @JsonProperty("isDining") boolean wantsDinner,
            @JsonProperty("consumption") int consumption) {
        this.id = id;
        this.type = type;
        this.passengerType = passengerType;
        this.wantsDinner = wantsDinner;
        this.consumption = consumption;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", passengerType='" + passengerType + '\'' +
                ", wantsDinner=" + wantsDinner +
                ", consumption=" + consumption +
                '}';
    }
}