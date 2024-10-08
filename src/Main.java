import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


class readFile {
    // Method to read JSON data from file
    public static JsonNode readInput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        // Displaying each entry of the JSON file
        Scanner scanner = new Scanner(System.in);
        for (JsonNode entry : data) {
            String entryAsString = entry.toString();
            System.out.println(entryAsString);
        }
        scanner.close();
        return data;
    }

    public static List<Creature> creaturesList = new ArrayList<>();

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

            // Create the Creature object
            Creature creature = new Creature(id, isHumanoid, planet, age, traits);
            System.out.println(creature.describe());


            creaturesList.add(creature);
        }

    }

    // Main method to run the code
    public static void main(String[] args) {
        try {
            // Read JSON data from the file
            JsonNode data = readInput();

            // Parse and process the JSON data
            parseInput(data);
            System.out.println(creaturesList.get(0).describe());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
