package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dict.Word;

public class App {
    public static void main(String[] args) {
        
    }
}

/* ///////////////////////////////////// NOTES ////////////////////////
// SERIALIZATION (this words btw)
List<Definition> defs = new ArrayList<Definition>();
defs.add(new Definition("hi2", "hi3"));
defs.add(new Definition("hi4", "hi5"));

List<String> syns = new ArrayList<String>();
syns.add("hi6");
syns.add("hi7");

List<String> ants = new ArrayList<String>();
ants.add("hi8");
ants.add("hi9");

System.out.println(new Gson().toJson(new Word("hi", defs, syns, ants)));



// SERIALIZING ARRAY OF WORDS (this also works)
List<Definition> defs = new ArrayList<Definition>();
defs.add(new Definition("hi2", "hi3"));
defs.add(new Definition("hi4", "hi5"));

List<String> syns = new ArrayList<String>();
syns.add("hi6");
syns.add("hi7");

List<String> ants = new ArrayList<String>();
ants.add("hi8");
ants.add("hi9");

List<Word> words = new ArrayList<Word>();
words.add(new Word("hi00", defs, syns, ants));
words.add(new Word("hi01", defs, syns, ants));
words.add(new Word("hi02", defs, syns, ants));

System.out.println(new Gson().toJson(words));

//////////////////// pretty printing ////////////////
Gson gson = new GsonBuilder().setPrettyPrinting().create(); <-- to keep it in tree structure

*/




/* //////////////////////////////////////////////// JAVA FX APP LEARNING ////////////////////////

public class App extends Application {

    Stage window;
    Scene one, two;

    @Override
    public void start(Stage stage) {
        window = stage;

        Label l1 = new Label("Sup, y'all've arrived at the first scene");
        Button b1 = new Button("Now go to the second scene");
        b1.setOnAction(e -> window.setScene(two));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(l1, b1);
        one = new Scene(layout1, 300, 300);

        Label l2 = new Label("Okay, now go back nothing to see here");
        Button b2 = new Button("Leave");
        b2.setOnAction(e -> window.setScene(one));

        // b2.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         window.setScene(one);
        //     }
        // });

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(l2, b2);
        two = new Scene(layout2, 600, 600);

        window.setScene(one);
        window.setTitle("Learning under construction");
        window.show();

        // String javaVersion = System.getProperty("java.version");
        // String javafxVersion = System.getProperty("javafx.version");
        // Label testVar = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        // testVar = new Label(Test.testString());
        // Scene scene = new Scene(new StackPane(testVar), 640, 480);
        // stage.setScene(scene);
        // stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        Word[] words = Word.getWords();
        for (Word word : words) {
            System.out.println(word.getWord());
        }
    }

}

*/
