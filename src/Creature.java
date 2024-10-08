import java.util.Arrays;

public class Creature {
    private int id;
    private Boolean isHuman;  // Nullable, defaults to "undeclared"
    private String planet;     // Nullable, defaults to "undeclared"
    private Integer age;       // Nullable, defaults to "undeclared"
    private String[] traits;   // Nullable, defaults to "undeclared"
    private String universe;

    // Constructor with fields defaulting to "Undeclared" if no input is provided
    public Creature(int id, Boolean isHuman, String planet, Integer age, String[] traits) {
        this.id = id; // id is required
        this.isHuman = (isHuman != null) ? isHuman : null;   // Defaults to null, representing undeclared
        this.planet = (planet != null) ? planet : "Undeclared";  // Default to "Undeclared" if planet is null
        this.age = (age != null) ? age : null;   // Defaults to null, representing undeclared
        this.traits = (traits != null && traits.length > 0) ? traits : new String[]{"Undeclared"};  // Default to "Undeclared"
        this.universe = "Unknown"; // Default value for universe
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
