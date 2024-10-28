package Lab1.Task4;
import Lab1.Task2.FileReader;
import Lab1.Task2.TextData;


public class Main4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide at least one file path as a command-line argument.");
            return;
        }

        for (String filePath : args) {
            System.out.println("Processing file: " + filePath);

            FileReader fr = new FileReader();
            TextData txt = new TextData(fr.readFileIntoString(filePath), filePath);

            System.out.println("File Name: " + txt.getFileName());
            System.out.println("Number of Consonants: " + txt.getNumberOfConsonants());
            System.out.println("Number of Vowels: " + txt.getNumberOfVowels());
            System.out.println("Number of Letters: " + txt.getNumberOfLetters());
            System.out.println("Longest Word: " + txt.getLongestWord());
            System.out.println("Number of Sentences: " + txt.getNumberOfSentences());
            System.out.println("Text Content:\n" + txt.getText());
            System.out.println("\n----------------------------------\n");
        }
    }
}
