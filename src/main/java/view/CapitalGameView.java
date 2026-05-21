package view;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CapitalGameView {

    private final Label capital;
    private final BorderPane borderPane;
    private final Button button1;
    private final Button button2;
    private final Button button3;
    private final Button button4;

    public CapitalGameView() {
        capital = new Label();
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
        VBox vBox = new VBox(capital,hBox2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);
        borderPane = new BorderPane();
        borderPane.setCenter(vBox);
    }

    public Label getCapital() {
        return capital;
    }

    public BorderPane getBorderPane() {
        return borderPane;
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
}
