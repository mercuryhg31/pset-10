package dict;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Word {

    private static Word[] words = readJSON();

    private String word;
    private Definition[] definitions;
    private String[] synonyms;
    private String[] antonyms;

    public Word(String word, Definition[] definitions, String[] synonyms, String[] antonyms) {
        this.word = word;
        this.definitions = definitions;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    public String getWord() {
        return word;
    }

    public Definition[] getDefinitions() {
        return definitions;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public String[] getAntonyms() {
        return antonyms;
    }

    private static Word[] readJSON() {
        String filePath = "Dictionary/words/words.json"; // alter to from where the program is being run
        try {
            File file = new File(filePath);
            System.out.println(file.getAbsolutePath());
            return new Gson().fromJson(new FileReader(filePath), Word[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void resetWords() {
        words = readJSON();
    }

    public static Word[] getWords() {
        return words;
    }
}