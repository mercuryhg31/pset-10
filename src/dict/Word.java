package dict;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
        words = sortWords(words);
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
     * <p> 2/20/20 19:19 - now ordered by relevance to query (this is super annoying to do)</p>
     * 
     * @param query
     * @return ArrayList<Word> of similar words to query
     */
    public static ArrayList<Word> findMatches(String query) {
        ArrayList<Word> matches = new ArrayList<Word>();
        ArrayList<Integer> sort = new ArrayList<Integer>();
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        ArrayList<Word> output = new ArrayList<Word>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord().contains(query)) {
                matches.add(words.get(i));
                sort.add(words.get(i).getWord().indexOf(query));
                sorted.add(words.get(i).getWord().indexOf(query));
            }
        } Collections.sort(sorted);
        // int limit = matches.size();
        // for (int j = 0; j < limit; j++) {
        while (matches.size() > 0) {
            for (int i = 0; i < sort.size(); i++) {
                if (sorted.get(0) == sort.get(i)) {
                    output.add(matches.get(i));
                    sorted.remove(0);
                    sort.remove(i);
                    matches.remove(i);
                }
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

    /**
     * Returns all words from words.json as ArrayList of Word objects
     * Now sorted alphabetically because it means other stuff gets automatically alphabetically sorted, yipee
     * 
     * @return
     */
    private static ArrayList<Word> readJSON() {
        try {
            Word[] temp = new Gson().fromJson(new FileReader(filePath), Word[].class);
            return sortWords(new ArrayList<Word>(Arrays.asList(temp)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Takes ArrayList of Word objects and returns them sorted alphabetically
     * 
     * @param un
     * @return alphabetically sorted ArrayList of Word objects
     */
    public static ArrayList<Word> sortWords(ArrayList<Word> un) {
        ArrayList<String> deux = new ArrayList<String>();
        for (Word word : un) {
            deux.add(word.getWord());
        } Collections.sort(deux);

        ArrayList<Word> trois = new ArrayList<Word>();
        for (int i = 0; i < deux.size(); i++) {
            for (int j = 0; j < un.size(); j++) {
                if (deux.get(i).equals(un.get(j).getWord())) {
                    System.out.println(un.get(j).getWord());
                    trois.add(un.get(j));
                    break;
                }
            }
        } return trois;
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