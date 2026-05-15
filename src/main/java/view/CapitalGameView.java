package view;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CapitalGameView {
    Label placeholder;
    BorderPane borderPane;

    public CapitalGameView(Stage stage) {
        placeholder = new Label("Capital Game");
        borderPane = new BorderPane();
        borderPane.setCenter(placeholder);
    }
}
