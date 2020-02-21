package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
        GridPane left = new GridPane();
        left.setGridLinesVisible(true);

        ColumnConstraints col1 = new ColumnConstraints(); col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints(); col2.setPercentWidth(50);
        left.getColumnConstraints().addAll(col1, col2);

        // RowConstraints row1 = new RowConstraints();
        // RowConstraints row2 = new RowConstraints();
        // left.getRowConstraints().addAll(row1, row2);

        Button add = new Button("Add");
        Button remove = new Button("Remove");

        TextField searchBox = new TextField("Search");
        searchBox.setOnKeyTyped(keyEvent -> {
            // TODO get matches of searchBox.getValue() here
        });

        GridPane.setConstraints(add, 0, 0, 2, 1);
        GridPane.setConstraints(remove, 1, 0, 1, 1);
        GridPane.setConstraints(searchBox, 0, 1, 2, 1); // Node, colIdx, rowIdx, colSpan, rowSpan

        left.getChildren().addAll(add);

        setup.setLeft(left);
    }

    void setCenterFrame() {
        GridPane center = new GridPane();
        center.setGridLinesVisible(true);

        center.getChildren().addAll(new Label("hi center"));

        setup.setCenter(center);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

// public class App {
//     public static void main(String[] args) {
//         ArrayList<Definition> defs = new ArrayList<Definition>();
//         defs.add(new Definition("hi", "greeting"));
//         defs.add(new Definition("hi", "greeting"));
//         defs.add(new Definition("hi", "greeting"));
//         ArrayList<String> syn = new ArrayList<String>();
//         syn.add("hello");
//         syn.add("howdy");
//         syn.add("how do you do?");
//         ArrayList<String> ant = new ArrayList<String>();
//         ant.add("bye");
//         ant.add("farewell");
//         ant.add("get lost");
//         Word word = new Word("hi", defs, syn, ant);
//         Word.addWord(word);
//         Word.writeJSON();

//         ArrayList<Word> matches = Word.findMatches("a");
//         for (Word wyrd : matches) {
//             System.out.println("Matches with query : " + wyrd.getWord());
//         }

//         Word.deleteWord("hi");
//         Word.writeJSON();
//     }
// }