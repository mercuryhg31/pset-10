package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    Stage window;
    BorderPane setup = new BorderPane();

    @Override
    public void start(Stage stage) {
        window = stage;

        setLeftFrame();
        setCenterFrame();

        Scene main = new Scene(setup, 500, 500);

        window.setScene(main);
        window.setTitle("Desktop Dictionary");
        window.show();
    }

    void setLeftFrame() {
        StackPane left = new StackPane();

        left.getChildren().add(new Label("hi left"));

        setup.setLeft(left);
    }

    void setCenterFrame() {
        StackPane center = new StackPane();
        center.getChildren().add(new Label("hi center"));

        setup.setCenter(center);
    }

    public static void main(String[] args) {
        launch(args);
    }

}