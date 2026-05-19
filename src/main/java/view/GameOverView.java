package view;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class GameOverView {
    Text gameOverText;
    Text scoreText;
    Text highScoreText;
    Button returnMenu;
    BorderPane borderPane;

    public GameOverView(Stage stage){
        gameOverText = new Text("Game Over");
        scoreText = new Text("Score: 0");
        highScoreText = new Text("High Score: 0");
        returnMenu = new Button("Zurück zum Menü");
        VBox vBox = new VBox(gameOverText,scoreText,highScoreText,returnMenu);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(vBox);
        hBox.setAlignment(Pos.CENTER);
        borderPane = new BorderPane();
        borderPane.setCenter(hBox);
    }

    public BorderPane getBorderPane(){
        return borderPane;
    }

    public Text getGameOverText() {
        return gameOverText;
    }

    public Text getScoreText() {
        return scoreText;
    }

    public Text getHighScoreText() {
        return highScoreText;
    }

    public Button getReturnMenu() {
        return returnMenu;
    }
}
