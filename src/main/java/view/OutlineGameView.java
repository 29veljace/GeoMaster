package view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.*;

public class OutlineGameView {

    private final ImageView imageView;
    private final Button button1;
    private final Button button2;
    private final Button button3;
    private final Button button4;
    private final BorderPane borderPane;

    public OutlineGameView() {
        imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        HBox hBox = new HBox(imageView);
        hBox.setAlignment(Pos.CENTER);


        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        VBox vBox1 = new VBox(button1,button2);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(30);
        VBox vBox2 = new VBox(button3,button4);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(30);
        HBox hBox2 = new HBox(vBox1,vBox2);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(30);
        hBox.setSpacing(30);
        VBox vBox = new VBox(hBox,hBox2);
        vBox.setSpacing(60);
        vBox.setAlignment(Pos.CENTER);
        borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        borderPane.getStyleClass().add("game-pane");
        borderPane.setId("outlineGamePane");
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButton4() {
        return button4;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
}
