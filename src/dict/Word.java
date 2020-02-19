package dict;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Word {

    private static String filePath = "Dictionary/words/words.json"; // alter to from where the program is being run
    // Reader reader = new FileReader(System.getProperty("user.dir") + File.separator + "words.json");
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

    public static int deleteWord(String query) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord() == query) {
                words.remove(i);
                return 0;
            }
        } return 1;
    }

    public static Word findWord(String query) {
        for (Word word : words) {
            if (word.getWord() == query) {
                return word;
            }
        } return null;
    }

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

    public static void resetWords() { // TODO make instead to write words list to words.json
        words = readJSON();
    }

    public static List<Word> getWords() {
        return words;
    }
}