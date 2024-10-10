import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonCreate {
    public static JSONObject StarWars1 = new JSONObject();
    public static JSONObject Hitchhiker1 = new JSONObject();
    public static JSONObject Marvel1 = new JSONObject();
    public static JSONObject LOTR1 = new JSONObject();
    public static JSONArray StarWars = new JSONArray();
    public static JSONArray Hitchhiker = new JSONArray();
    public static JSONArray Marvel = new JSONArray();
    public static JSONArray LOTR = new JSONArray();
    public static void createJsons(){
        StarWars1.put("StarWarsUniverse",StarWars);
        Hitchhiker1.put("HitchhikerUniverse",Hitchhiker);
        Marvel1.put("MarvelUniverse",Marvel);
        LOTR1.put("LOTRUniverse",LOTR);
    }
    public static void addtoJSON (Creature creature, JSONObject creatureJson){
        if (creature.getUniverse() == "StarWars")
            StarWars.put(creatureJson);
        else if(creature.getUniverse() == "Hitchhiker")
            Hitchhiker.put(creatureJson);
        else if(creature.getUniverse() == "Marvel")
            Marvel.put(creatureJson);
        else if(creature.getUniverse() == "LOTR")
            LOTR.put(creatureJson);
    }


    public static void createFiles() {

        try (FileWriter marvelOutput = new FileWriter("marvel.json")) {
            // Write JSON objects with proper indentation (4 spaces per level)
            marvelOutput.write(Marvel1.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter lotrOutput = new FileWriter("lotr.json")) {
            // Write JSON objects with proper indentation (4 spaces per level)
            lotrOutput.write(LOTR1.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter hitchhikersOutput = new FileWriter("hitchhikers.json")) {
            // Write JSON objects with proper indentation (4 spaces per level)
            hitchhikersOutput.write(Hitchhiker1.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter starWarsOutput = new FileWriter("starWars.json")) {
            // Write JSON objects with proper indentation (4 spaces per level)
            starWarsOutput.write(StarWars1.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void parseInput(JsonNode data) throws IOException {
        createJsons();
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

            // Create the Creature object
            Creature creature = new Creature(id, isHumanoid, planet, age, traits);
            creature.checkUniverse();
            JSONObject creatureJson = new JSONObject();
            creatureJson.put("id", id);
            creatureJson.put("isHumanoid", isHumanoid);
            creatureJson.put("planet", planet);
            creatureJson.put("age", age);
            creatureJson.put("traits", traits);
            addtoJSON(creature,creatureJson);
            createFiles();
        }

    }


}
