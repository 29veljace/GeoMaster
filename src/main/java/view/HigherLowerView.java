package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HigherLowerView {

    private final BorderPane borderPane;
    private final Label label;
    private final Button button1;
    private final Button button2;
    private final ImageView imageView1;
    private final ImageView imageView2;
    private final Text score;
    private final Text scoreNumber;

    public HigherLowerView(Stage stage) {
        score = new Text("Score");
        score.setId("score");
        score.setFill(Color.WHITESMOKE);
        scoreNumber = new Text("0");
        scoreNumber.setId("scoreNumber");
        scoreNumber.setFill(Color.WHITESMOKE);
        VBox scoreBox = new VBox(score, scoreNumber);
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setPadding(new Insets(10, 10, 10, 10));

        label = new Label();
        label.setId("HLquestion");
        button1 = new Button();
        button2 = new Button();
        HBox hBox = new HBox(button1, button2);
        hBox.setSpacing(100);
        hBox.setAlignment(Pos.CENTER);
        imageView1 = new ImageView();
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(150);
        imageView1.setPreserveRatio(true);
        imageView2 = new ImageView();
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(150);
        imageView2.setPreserveRatio(true);
        HBox hBox1 = new HBox(imageView1, imageView2);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(100);
        VBox vBox = new VBox(label, hBox1, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);
        borderPane = new BorderPane();
        borderPane.setTop(scoreBox);
        borderPane.setCenter(vBox);
        borderPane.getStyleClass().add("game-pane");
        borderPane.setId("HLPane");
    }

    public BorderPane getBorderPane() {return borderPane;}
    public Label getLabel() {return label;}
    public Button getButton1() {return button1;}
    public Button getButton2() {return button2;}
    public ImageView getImageView1() {return imageView1;}
    public ImageView getImageView2() {return imageView2;}
    public Text getScoreNumber() {return scoreNumber;}
}
