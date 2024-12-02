package Lab1.Task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    // Constructor that initializes the text and computes data
    public TextData(String text,String path) {
        this.fileName = path;
        this.text = text;
        this.numberOfVowels = countVowels(text);
        this.numberOfConsonants = countConsonants(text);
        this.numberOfLetters = countLetters(text);
        this.numberOfSentences = countSentences(text);
        this.longestWord = findLongestWord(text);
    }

    // Helper method to count vowels
    private int countVowels(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Helper method to count consonants
    private int countConsonants(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }
    private int countLetters(String text) {

        return (countConsonants(text) + countVowels(text));
    }

    private int countSentences(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }

    // Helper method to find the longest word
    private String findLongestWord(String text) {
        String longest = "";
        for (String word : text.split("\\W+")) { // Splits by non-word characters
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Getters
    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

}
