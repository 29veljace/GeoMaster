package view;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        gameOverText.setId("gameOverInfo");
        gameOverText.setFill(Color.WHITESMOKE);

        scoreText = new Text("Score: 0");
        scoreText.setId("gameOverInfo");
        scoreText.setFill(Color.WHITESMOKE);

        highScoreText = new Text("High Score: 0");
        highScoreText.setId("gameOverInfo");
        highScoreText.setFill(Color.WHITESMOKE);

        returnMenu = new Button("Zurück zum Menü");
        returnMenu.setId("gameOverButton");
        VBox vBox = new VBox(gameOverText,scoreText,highScoreText,returnMenu);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(vBox);
        hBox.setAlignment(Pos.CENTER);
        borderPane = new BorderPane();
        borderPane.setCenter(hBox);
        borderPane.setStyle("-fx-background-color: linear-gradient(to bottom, #0d9488, #042f2e)");
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
