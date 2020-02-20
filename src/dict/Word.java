package dict;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Word {

    private static String filePath = "Dictionary/words/words.json"; // alter to from where the program is being run
    private static ArrayList<Word> words = readJSON();

    private String word;
    private ArrayList<Definition> definitions;
    private ArrayList<String> synonyms;
    private ArrayList<String> antonyms;

    public Word(String word, ArrayList<Definition> definitions, ArrayList<String> synonyms, ArrayList<String> antonyms) {
        this.word = word;
        this.definitions = definitions;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    public static void addWord(Word word) {
        if (findWord(word.getWord()) != null) {
            System.out.println("\nCannot create duplicate word.\n");
            return;
        }
        words.add(word);
        System.out.println("\nWord added successfully.\n");
    }

    /**
     * Finds index of word that matches query string and deletes object at index.
     * 
     * @param query
     * @return if error occurred
     */
    public static boolean deleteWord(String query) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord().equals(query)) {
                words.remove(i);
                System.out.println("\nWord deleted successfully.\n");
                return false;
            }
        }
        System.out.println("\nWord deletion unsuccessful.\n");
        return true;
    }

    /**
     * Finds word object that matches query string.
     * 
     * @param query
     * @return Word matching query string
     */
    public static Word findWord(String query) {
        for (Word word : words) {
            if (word.getWord().equals(query)) {
                return word;
            }
        } return null;
    }

    /**
     * Finds words that contain query string.
     * 
     * @param query
     * @return ArrayList<Word> of similar words to query
     */
    public static ArrayList<Word> findMatches(String query) {
        ArrayList<Word> output = new ArrayList<Word>();
        for (Word word : words) {
            if (word.getWord().contains(query)) {
                output.add(word);
            }
        } return output;
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public ArrayList<String> getAntonyms() {
        return antonyms;
    }

    private static ArrayList<Word> readJSON() {
        try {
            Word[] temp = new Gson().fromJson(new FileReader(filePath), Word[].class);
            return new ArrayList<Word>(Arrays.asList(temp));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void resetWords() { // may be unnecessary
        words = readJSON();
    }

    public static void writeJSON() {
        try {
            FileWriter write = new FileWriter(filePath);
            write.write(new GsonBuilder().setPrettyPrinting().create().toJson(Word.getWords()));
            write.close();
            System.out.println("\nSaving data successful.\n");
        } catch (IOException e) {
            System.out.println("\nSaving data unsuccessful.\n");
            e.printStackTrace();
        }
    }

    public static ArrayList<Word> getWords() {
        return words;
    }
}