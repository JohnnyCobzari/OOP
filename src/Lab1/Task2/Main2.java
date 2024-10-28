package Lab1.Task2;

public class Main2 {
    public static void main(String[] args) {
FileReader fr = new FileReader();
TextData txt = new TextData(fr.readFileIntoString(args[0]),args[0]);
System.out.println(txt.getFileName());
System.out.println(txt.getNumberOfConsonants());
System.out.println(txt.getNumberOfVowels());
System.out.println(txt.getNumberOfLetters());
System.out.println(txt.getLongestWord());
System.out.println(txt.getNumberOfSentences());
System.out.println(txt.getText());
    }
}
