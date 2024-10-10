import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


class Main {

    // Main method to run the code
    public static void main(String[] args) {
        try {

            JsonNode data = readFile.readInput();
            JsonCreate.parseInput(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
