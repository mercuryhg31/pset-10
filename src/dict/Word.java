package dict;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
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
    private static List<Word> words = readJSON();

    private String word;
    private List<Definition> definitions;
    private List<String> synonyms;
    private List<String> antonyms;

    public static class Definition {
        private String def;
        private String pos;

        public Definition(String def, String pos) {
            this.def = def;
            this.pos = pos;
        }

        public String getDefinition() {
            return def;
        }

        public String getPOS() {
            return pos;
        }
    }

    public Word(String word, List<Definition> definitions, List<String> synonyms, List<String> antonyms) {
        this.word = word;
        this.definitions = definitions;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
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

        // JsonDeserializer<Word> deserializer = new JsonDeserializer<Word>() {
        //     @Override
        //     public Word deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        //         JsonObject jsonObject = json.getAsJsonObject();
        //         JsonObject wholeDef = (JsonObject) jsonObject.get("definitions");

        //         Definition definition = new Definition(
        //             wholeDef.get("definiton").getAsString(),
        //             wholeDef.get("partOfSpeech").getAsString()
        //         );

        //         return new Word(
        //             jsonObject.get("")
        //         );
        //     }
        // };
        // return null;
    }

    public static void resetWords() {
        words = readJSON();
    }

    public static List<Word> getWords() {
        return words;
    }
}