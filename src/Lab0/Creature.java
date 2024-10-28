import java.util.Arrays;

public class Creature {
    private int id;
    private Boolean isHuman;
    private String planet;
    private Integer age;
    private String[] traits;
    private String universe;


    public Creature(int id, Boolean isHuman, String planet, Integer age, String[] traits) {
        this.id = id;
        this.isHuman = isHuman;
        this.planet =planet;
        this.age = age;
        this.traits =traits;
        this.universe = "Unknown";
    }

    // Method to describe the creature
    public String describe() {
        return "This creature is " + id
                +(isHuman != null ? (isHuman ? "human" : "not human") : "undeclared") +
                ", from " + (planet != null ? planet : "undeclared") +
               ", age " + (age != null ? age : "undeclared") +
               ", with traits: " + (traits != null ? Arrays.toString(traits) : "undeclared")
               + ", from universe: " + universe;
    }

    public String getUniverse() {
        return universe;
    }

    public int  getId() {return id;}

    public Boolean getIsHuman() {
        return isHuman;
    }

    public String getPlanet() {
        return planet;
    }

    public Integer getAge() {
        return age;
    }

    public String[] getTraits() {
        return traits;
    }

    public void setUniverse(String universe) {
        this.universe = universe;

    }


}
