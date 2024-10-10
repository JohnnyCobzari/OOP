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

    // Method to describe the creature
    public String describe() {
        return "This creature is " + id
//                +(isHuman != null ? (isHuman ? "human" : "not human") : "undeclared") +
//                ", from " + (planet != null ? planet : "undeclared") +
//                ", age " + (age != null ? age : "undeclared") +
//                ", with traits: " + (traits != null ? Arrays.toString(traits) : "undeclared")
               + ", from universe: " + universe;
    }
    public boolean containsAnyTrait(String[] traits, String... expectedTraits) {
        if (traits == null || traits.length == 0) {
            return false;
        }
        for(String trait : expectedTraits){
            if(Arrays.asList(traits).contains(trait)){
                return true;
            }
        }
        return false;
    }
    public void checkUniverse() {

        if ((isHuman == null || !isHuman)
                && (planet == null || planet.equalsIgnoreCase("Kashyyyk"))
                && (age == null || (age >= 0 && age <= 400))
                && (traits == null || containsAnyTrait(traits, "HAIRY", "TALL"))) {
            universe = "StarWars";
        }

        else if ((isHuman == null || !isHuman)
                && (planet == null || planet.equalsIgnoreCase("Endor"))
                && (age == null || (age >= 0 && age <= 60))
                && (traits == null || containsAnyTrait(traits, "SHORT", "HAIRY"))) {
            universe = "StarWars";
        }
        // Marvel Universe (Asgardian)
        else if ((isHuman == null || isHuman)
                && (planet == null || planet.equalsIgnoreCase("Asgard"))
                && (age == null || (age >= 0 && age <= 5000))
                && (traits == null || containsAnyTrait(traits, "BLONDE", "TALL"))) {
            universe = "Marvel";
        }
        // Hitchhiker's Universe (Betelgeusian)
        else if ((isHuman == null || isHuman)
                && (planet == null || planet.equalsIgnoreCase("Betelgeuse"))
                && (age == null || (age >= 0 && age <= 100))
                && (traits == null || containsAnyTrait(traits, "EXTRA_ARMS", "EXTRA_HEAD"))) {
            universe = "Hitchhiker";
        }
        // Hitchhiker's Universe (Vogons)
        else if ((isHuman == null || !isHuman)
                && (planet == null || planet.equalsIgnoreCase("Vogsphere"))
                && (age == null || (age >= 0 && age <= 200))
                && (traits == null || containsAnyTrait(traits, "GREEN", "BULKY"))) {
            universe = "Hitchhiker";
        }
        // Lord of the Rings (Elf)
        else if ((isHuman == null || isHuman)
                && (planet == null || planet.equalsIgnoreCase("Earth"))
                && (age == null || (age == null || age > 200)) // indefinite age for Elves
                && (traits == null || containsAnyTrait(traits, "BLONDE", "POINTY_EARS"))) {
            universe = "LOTR";
        }
        // Lord of the Rings (Dwarf)
        else if ((isHuman == null || isHuman)
                && (planet == null || planet.equalsIgnoreCase("Earth"))
                && (age == null || (age >= 0 && age <= 200))
                && (traits == null || containsAnyTrait(traits, "SHORT", "BULKY"))) {
            universe = "LOTR";
        }
        // If no match, leave universe as "Unknown"
        else {
            universe = "Unknown";
        }
    }

    public String getUniverse() {
        return universe;
    }

}
