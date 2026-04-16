package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainMenuView {
    public final Button spiel1;
    public final Button spiel2;
    public final Button spiel3;
    public final Button spiel4;
    public final Text willkommen;
    public final Text info;
    private BorderPane borderPane = new BorderPane();

    public MainMenuView(){
        spiel1 = new Button("Flaggen erraten");
        spiel2 = new Button("Länderumrisse erkennen");
        spiel3 = new Button("Viele Fakten => ein Land");
        spiel4 = new Button("Higher Or Lower");
        willkommen = new Text("Geomaster");
        willkommen.setId("willkommen");
        info = new Text("Wählen Sie einen der Spielmodi aus");
        info.setId("info");
        HBox hBox1 = new HBox(spiel1,spiel2);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(spiel4,spiel3);
        hBox2.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(willkommen,info,hBox1,hBox2);
        vBox.setAlignment(Pos.CENTER);
        VBox.setMargin(hBox1,new Insets(140,0,30,0));
        VBox.setMargin(info,new Insets(35,0,0,0));
        hBox1.setSpacing(30);
        hBox2.setSpacing(30);
        borderPane.setCenter(vBox);
        borderPane.setId("borderpane");
    }

    public Button getSpiel1() {
        return spiel1;
    }

    public Button getSpiel2() {
        return spiel2;
    }

    public Button getSpiel3() {
        return spiel3;
    }

    public Button getSpiel4() {
        return spiel4;
    }

    public Text getWillkommen() {
        return willkommen;
    }

    public Text getInfo() {
        return info;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
}
