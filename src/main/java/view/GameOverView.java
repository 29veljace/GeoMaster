package view;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class GameOverView {
    Label placeholder;
    BorderPane borderPane;

    public GameOverView(Stage stage){
        placeholder = new Label("Game Over");
        borderPane = new BorderPane();
        borderPane.setCenter(placeholder);
    }

    public BorderPane getBorderPane(){
        return borderPane;
    }
}
