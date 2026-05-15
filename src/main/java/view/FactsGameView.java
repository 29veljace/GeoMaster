package view;

import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FactsGameView {
    Label placeholder;
    BorderPane borderPane = new BorderPane();

    public FactsGameView(Stage stage){
        placeholder = new Label("Facts Game");
        borderPane = new BorderPane();
        borderPane.setCenter(placeholder);
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
}
