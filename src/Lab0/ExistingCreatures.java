package Lab0;

public class ExistingCreatures {
    private Boolean isHuman;
    private String planet;
    private Integer age1;
    private Float age2;
    private String[] traits;
    private String universe;

    // Constructor with parameters
    public ExistingCreatures(Boolean isHuman, String planet, Integer age1, Float age2, String[] traits, String universe) {
        this.isHuman = (isHuman != null) ? isHuman : null;
        this.planet = (planet != null) ? planet : "undeclared";
        this.age1 = age1;
        this.age2 = age2;
        this.traits = (traits != null) ? traits : new String[]{"undeclared"};
        this.universe = universe;
    }

    // Getters
    public Boolean getIsHuman() { return isHuman; }
    public String getPlanet() { return planet; }
    public Integer getAge1() { return age1; }
    public Float getAge2() { return age2; }
    public String[] getTraits() { return traits; }
    public String getUniverse() { return universe; }
}
