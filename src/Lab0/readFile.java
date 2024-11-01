package Lab0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class readFile {// Method to read JSON data from file
    public static JsonNode readInput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/Lab0/input (1).json");
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
