package Lab0;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class parser {


    public static List<Creature> CreatureList = new ArrayList<>();
    public static Lab0.Classifier Classifier = new Classifier();

    static void parseInput(JsonNode data) throws IOException {
        for (JsonNode entry : data) {
            String entryAsString = entry.toString();
            JSONObject jsonpObject = new JSONObject(entryAsString);

            int id = jsonpObject.has("id") ? jsonpObject.getInt("id") : 0;  // Default to 0 if no id

            // Handle isHumanoid (nullable Boolean)
            Boolean isHumanoid = jsonpObject.has("isHumanoid") ? jsonpObject.getBoolean("isHumanoid") : null;

            // Handle planet (nullable String)
            String planet = jsonpObject.has("planet") ? jsonpObject.getString("planet") : null;

            // Handle age (nullable Integer)
            Integer age = jsonpObject.has("age") ? jsonpObject.getInt("age") : null;

            // Handle traits (nullable String array)
            JSONArray jsonTraits = jsonpObject.has("traits") ? jsonpObject.getJSONArray("traits") : null;
            String[] traits = null;
            if (jsonTraits != null) {
                traits = new String[jsonTraits.length()];
                for (int i = 0; i < jsonTraits.length(); i++) {
                    traits[i] = jsonTraits.getString(i);
                }
            }

            Creature creature = new Creature(id, isHumanoid, planet, age, traits);

            Classifier.checkUniverse2(creature);
            CreatureList.add(creature);


        }

    }


}
