package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application implements EventHandler<ActionEvent> {

    Button button;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Dictionary");
        button = new Button("Words");

        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();

        // String javaVersion = System.getProperty("java.version");
        // String javafxVersion = System.getProperty("javafx.version");
        // Label testVar = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        // testVar = new Label(Test.testString());
        // Scene scene = new Scene(new StackPane(testVar), 640, 480);
        // stage.setScene(scene);
        // stage.show();
    }

    @Override
    public void handle (ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("Hello!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
