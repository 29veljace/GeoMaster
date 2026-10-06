package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import util.HighScoreManager;

public class FactsGameStreakView {
    private final Label label;
    private final Button button;
    private final HBox hBox;
    public FactsGameStreakView(){
        label = new Label("You won this mode " + HighScoreManager.getCountFactsGameStreak() + " times!");
        label.setId("score");
        label.setTextFill(Color.WHITESMOKE);

        button = new Button("Back to Main Menu");
        button.setId("gameOverButton");
        VBox vBox = new VBox(label,button);
        vBox.setSpacing(25);
        vBox.setAlignment(Pos.CENTER);
        hBox = new HBox(vBox);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: linear-gradient(to bottom, #5b9bd5, #3878b8);");
    }

    public HBox gethBox() {
        return hBox;
    }

    public Button getButton() {
        return button;
    }
}
