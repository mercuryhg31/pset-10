package app;

import java.util.List;
import java.util.ArrayList;

import dict.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*; // TODO is this swing?

public class App {
    public static void main(String[] args) {
        ArrayList<Definition> defs = new ArrayList<Definition>();
        defs.add(new Definition("hi", "greeting"));
        defs.add(new Definition("hi", "greeting"));
        defs.add(new Definition("hi", "greeting"));
        ArrayList<String> syn = new ArrayList<String>();
        syn.add("hello");
        syn.add("howdy");
        syn.add("how do you do?");
        ArrayList<String> ant = new ArrayList<String>();
        ant.add("bye");
        ant.add("farewell");
        ant.add("get lost");
        Word word = new Word("hi", defs, syn, ant);
        Word.addWord(word);
        Word.writeJSON();

        ArrayList<Word> matches = Word.findMatches("ui");
        for (Word wyrd : matches) {
            System.out.println("Matches with query : " + wyrd.getWord());
        }

        Word.deleteWord("hi");
        Word.writeJSON();
    }
}

// public class App extends Application {

//     Stage window;
//     BorderPane setup = new BorderPane();

//     @Override
//     public void start(Stage stage) {
//         window = stage;

//         setLeftFrame();
//         setCenterFrame();

//         Scene main = new Scene(setup, 500, 500);

//         window.setScene(main);
//         window.setTitle("Desktop Dictionary");
//         window.show();
//     }

//     void setLeftFrame() {
//         StackPane left = new StackPane();

//         left.getChildren().add(new Label("hi left"));

//         setup.setLeft(left);
//     }

//     void setCenterFrame() {
//         StackPane center = new StackPane();
//         center.getChildren().add(new Label("hi center"));

//         setup.setCenter(center);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }

// }