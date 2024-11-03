package Lab1.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public String readFileIntoString(String path) {
        try {
            // Read file contents into a single string
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            // Handle exception (print stack trace or return an error message)
            e.printStackTrace();
            return null; // or an empty string, depending on desired behavior
        }
    }
}
