package view;

import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class GameOverView {
    Text gameOverText;
    Button returnMenu;
    BorderPane borderPane;

    public GameOverView(Stage stage){
        gameOverText = new Text("Game Over");
        returnMenu = new Button("Zurück zum Menü");
        borderPane = new BorderPane();
    }
    public BorderPane getBorderPane(){
        return borderPane;
    }
}
