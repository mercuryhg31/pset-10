package gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.*;

import dict.Word;

public class Read {

    public static void jsonToWord() {

        try {
            JsonArray word = new Gson().fromJson(new FileReader("words.json"), JsonArray.class);
            System.out.println(word);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}