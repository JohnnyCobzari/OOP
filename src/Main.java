import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;



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
