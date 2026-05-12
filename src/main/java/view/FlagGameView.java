package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class FlagGameView {

    private ImageView imageView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private BorderPane borderPane;

    public FlagGameView(Stage stage) {
        imageView = new ImageView();
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
        HBox hBox = new HBox(vBox1,vBox2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        borderPane = new BorderPane();
        borderPane.setCenter(hBox);
        borderPane.setTop(imageView);
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
