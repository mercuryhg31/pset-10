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
    private static List<Word> words = readJSON();

    private String word;
    private List<Definition> definitions;
    private List<String> synonyms;
    private List<String> antonyms;

    public Word(String word, List<Definition> definitions, List<String> synonyms, List<String> antonyms) {
        this.word = word;
        this.definitions = definitions;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    public static void addWord(Word word) {
        words.add(word);
    }

    /**
     * Finds index of word that matches query string and deletes object at index.
     * 
     * @param query
     * @return 0 (successful) or 1 (unsuccessful)
     */
    public static int deleteWord(String query) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord() == query) {
                words.remove(i);
                return 0;
            }
        } return 1;
    }

    /**
     * Finds word object that matches query string.
     * 
     * @param query
     * @return Word matching query string
     */
    public static Word findWord(String query) {
        for (Word word : words) {
            if (word.getWord() == query) {
                return word;
            }
        } return null;
    }

    /**
     * Finds words that contain query string.
     * 
     * @param query
     * @return List<Word> of similar words to query
     */
    public static List<Word> findMatches(String query) {
        List<Word> output = new ArrayList<Word>();
        for (Word word : words) {
            if (word.getWord().contains(query)) {
                output.add(word);
            }
        } return null;
    }

    public String getWord() {
        return word;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    private static List<Word> readJSON() {
        try {
            Word[] temp = new Gson().fromJson(new FileReader(filePath), Word[].class);
            return Arrays.asList(temp);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void resetWords() { // may be unnecessary
        words = readJSON();
    }

    public void writeJSON() {
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

    public static List<Word> getWords() {
        return words;
    }
}