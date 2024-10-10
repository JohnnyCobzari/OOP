import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class readFile {// Method to read JSON data from file
    public static JsonNode readInput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/input (1).json");
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





}
