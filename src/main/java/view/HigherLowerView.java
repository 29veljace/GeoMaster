package view;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HigherLowerView {

    private final BorderPane borderPane;
    private final Label label;
    private final Button button1;
    private final Button button2;
    private final ImageView imageView1;
    private final ImageView imageView2;

    public HigherLowerView(Stage stage){
       label = new Label();
       button1 = new Button();
       button2 = new Button();
       HBox hBox = new HBox(button1,button2);
       hBox.setSpacing(100);
       hBox.setAlignment(Pos.CENTER);
       imageView1 = new ImageView();
       imageView2 = new ImageView();
       HBox hBox1 = new HBox(imageView1,imageView2);
       hBox1.setAlignment(Pos.CENTER);
       hBox1.setSpacing(100);
       VBox vBox = new VBox(label,hBox1,hBox);
       vBox.setAlignment(Pos.CENTER);
       vBox.setSpacing(25);
       borderPane = new BorderPane();
       borderPane.setCenter(vBox);
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public Label getLabel() {
        return label;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public ImageView getImageView1() {
        return imageView1;
    }

    public ImageView getImageView2() {
        return imageView2;
    }
}
