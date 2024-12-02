package Lab0;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;



class Main {

    // Main method to run the code
    public static void main(String[] args) {
        try {

            JsonNode data = readFile.readInput();
            parser.parseInput(data);
            views.WriteInOutputFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
