package Lab0;

import java.util.ArrayList;
import java.util.List;


public class CreatureManager {
    public static List<ExistingCreatures> ExistentCreatures = new ArrayList<>();

    // Method to add creatures
    public static void addCreature() {
        ExistentCreatures.add(new ExistingCreatures(false, "Kashyyyk", 0, 400.0f, new String[]{"HAIRY", "TALL"}, "StarWars"));
        ExistentCreatures.add(new ExistingCreatures(false, "Endor", 0, 60.0f, new String[]{"SHORT", "HAIRY"}, "StarWars"));
        ExistentCreatures.add(new ExistingCreatures(true, "Asgard", 0, 5000.0f, new String[]{"BLONDE", "TALL"}, "Marvel"));
        ExistentCreatures.add(new ExistingCreatures(true, "Betelgeuse", 0, 100.0f, new String[]{"EXTRA_ARMS", "EXTRA_HEAD"}, "Hitchhiker"));
        ExistentCreatures.add(new ExistingCreatures(false, "Vogsphere", 0, 200.0f, new String[]{"GREEN", "BULKY"}, "Hitchhiker"));
        ExistentCreatures.add(new ExistingCreatures(true, "Earth", 0, Float.POSITIVE_INFINITY, new String[]{"BLONDE", "POINTY_EARS"}, "LOTR"));
        ExistentCreatures.add(new ExistingCreatures(true, "Earth", 0, 200.0f, new String[]{"SHORT", "BULKY"}, "LOTR"));
    }
}
