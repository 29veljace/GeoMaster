package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HigherLowerView {
    Label placeholder;
    BorderPane borderPane;

    public HigherLowerView(Stage stage){
        placeholder = new Label("Higher Lower");
        borderPane = new BorderPane();
        borderPane.setCenter(placeholder);
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
}
