import java.util.Arrays;

public class Creature {
    private int id;
    private Boolean isHuman;  // Nullable, defaults to "undeclared"
    private String planet;     // Nullable, defaults to "undeclared"
    private Integer age;       // Nullable, defaults to "undeclared"
    private String[] traits;   // Nullable, defaults to "undeclared"
    private String universe;


    public Creature(int id, Boolean isHuman, String planet, Integer age, String[] traits) {
        this.id = id;
        this.isHuman = isHuman;
        this.planet =planet;
        this.age = age;
        this.traits =traits;
        this.universe = "Unknown";
    }

    // Getters and setters
    public Boolean isHuman() {
        return isHuman;
    }

    public void setHuman(Boolean isHuman) {
        this.isHuman = isHuman;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String[] getTraits() {
        return traits;
    }

    public void setTraits(String[] traits) {
        this.traits = traits;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    // Method to describe the creature
    public String describe() {
        return "This creature is " + (isHuman != null ? (isHuman ? "human" : "not human") : "undeclared") +
                ", from " + (planet != null ? planet : "undeclared") +
                ", age " + (age != null ? age : "undeclared") +
                ", with traits: " + (traits != null ? Arrays.toString(traits) : "undeclared") +
                ", in universe: " + universe;
    }
}
