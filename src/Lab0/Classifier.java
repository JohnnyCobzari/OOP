import java.util.Arrays;

public class Classifier {
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
    public void checkUniverse2(Creature creature) {
        CreatureManager.addCreature();

        for (ExistingCreatures sample : CreatureManager.ExistentCreatures) {
            if ((creature.getIsHuman() == null || creature.getIsHuman().equals(sample.getIsHuman()))
                    && (creature.getPlanet() == null || creature.getPlanet().equals(sample.getPlanet()))
                    && (creature.getAge() == null || isAgeInRange(creature.getAge(), sample.getAge1(), sample.getAge2()))
                    && (creature.getTraits() == null || containsAnyTrait(creature.getTraits(), sample.getTraits()))) {
                creature.setUniverse(sample.getUniverse());
                break;
            }
        }
    }

    // Helper method for age range comparison
    private boolean isAgeInRange(Integer age, Integer age1, Float age2) {
        double ageDouble = age;
        double min = (age1 != null) ? age1 : 0;
        double max = (age2 != null) ? age2 : Double.MAX_VALUE;
        return ageDouble >= min && ageDouble <= max;
    }

}
