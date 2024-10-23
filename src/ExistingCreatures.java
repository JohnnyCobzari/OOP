import java.util.ArrayList;
import java.util.List;

public class ExistingCreatures {
    private Boolean isHuman;  // Nullable, defaults to "undeclared"
    private String planet;     // Nullable, defaults to "undeclared"
    private Integer age1;
    private Float age2;
    private String[] traits;   // Nullable, defaults to "undeclared"
    private String universe;

    public ExistingCreatures(Boolean isHuman, String planet, Integer age1,Float age2, String[] traits, String universe) {
        this.isHuman = isHuman;
        this.planet =planet;
        this.age1 = age1;
        this.age2 = age2;
        this.traits =traits;
        this.universe =universe;
    }

    public static List<ExistingCreatures> ExistentCreatures = new ArrayList<>();
    public static void addCreature() {

        String[] wookieTraits = {"HAIRY", "TALL"};
        ExistingCreatures wookie = new ExistingCreatures(
                false,            // isHuman
                "Kashyyyk",       // planet
                0,                // age1 (Integer)
                400.0f,           // age2 (Float)
                wookieTraits,     // traits (String array)
                "StarWars"        // universe
        );
        String[] ewokTraits = {"SHORT", "HAIRY"};

        ExistingCreatures ewok = new ExistingCreatures(
                false,
                "Endor",
                0,
                60.0f,
                ewokTraits,
                "StarWars"
        );

        String[] asgardianTraits = {"BLONDE", "TALL"};

        ExistingCreatures asgardian = new ExistingCreatures(
                true,
                "Asgard",
                0,
                5000.0f,
                asgardianTraits,
                "Marvel"
        );

        String[] betelgeusianTraits = {"EXTRA_ARMS", "EXTRA_HEAD"};

        ExistingCreatures betelgeusian = new ExistingCreatures(
                true,
                "Betelgeuse",
                0,
                100.0f,
                betelgeusianTraits,
                "Hitchhiker"
        );

        String[] vogonTraits = {"GREEN", "BULKY"};

        ExistingCreatures vogon = new ExistingCreatures(
                false,
                "Vogsphere",
                0,
                200.0f,
                vogonTraits,
                "Hitchhiker"
        );

        String[] elfTraits = {"BLONDE", "POINTY_EARS"};

        ExistingCreatures elf = new ExistingCreatures(
                true,
                "Earth",
                0,
                Float.POSITIVE_INFINITY, // Represents indefinite age
                elfTraits,
                "LOTR"
        );

        String[] dwarfTraits = {"SHORT", "BULKY"};

        ExistingCreatures dwarf = new ExistingCreatures(
                true,
                "Earth",
                0,
                200.0f,
                dwarfTraits,
                "LOTR"
        );
        ExistentCreatures.add(wookie);
        ExistentCreatures.add(ewok);
        ExistentCreatures.add(asgardian);
        ExistentCreatures.add(betelgeusian);
        ExistentCreatures.add(vogon);
        ExistentCreatures.add(elf);
        ExistentCreatures.add(dwarf);

    }

    public Boolean getIsHuman() {
        return isHuman;
    }

    public String getPlanet() {
        return planet;
    }

    public Integer getAge1() {
        return age1;
    }

    public Float getAge2() {
        return age2;
    }

    public String[] getTraits() {
        return traits;
    }

    public String getUniverse() {
        return universe;
    }


}





