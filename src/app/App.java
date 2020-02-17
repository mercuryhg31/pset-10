package app;

import dict.Word;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App {
    public static void main(String[] args) {
        Word[] words = Word.getWords();
        for (Word word : words) {
            String[] ants = word.getSynonyms();
            for (String ant : ants) {
                System.out.print(ant);
            }
        }
    }
}

/*

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
