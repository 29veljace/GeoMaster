package view;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class MainMenuView {
    public final Button flagGuessing;
    public final Button outlineGuessing;
    public final Button factsGame;
    public final Button higherLower;
    public final Button capitalGame;
    public final Text willkommen;
    public final Text info;
    private BorderPane borderPane = new BorderPane();

    public MainMenuView(){
        flagGuessing    = new Button("Flaggen erraten");
        outlineGuessing = new Button("Länderumrisse erkennen");
        factsGame       = new Button("Viele Fakten → ein Land");
        higherLower     = new Button("Higher Or Lower");
        capitalGame     = new Button("Hauptstädte erraten");

        // CSS-IDs für individuelle Button-Farben
        flagGuessing.setId("btnFlags");
        outlineGuessing.setId("btnOutline");
        factsGame.setId("btnFacts");
        higherLower.setId("btnHigherLower");
        capitalGame.setId("btnCapital");

        willkommen = new Text("GeoMaster");
        willkommen.setFill(Color.WHITESMOKE);
        willkommen.setId("willkommen");
        info = new Text("Wählen Sie einen der Spielmodi aus");
        info.setFill(Color.WHITESMOKE);
        info.setId("info");

        HBox hBox1 = new HBox(flagGuessing, outlineGuessing);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(higherLower, factsGame, capitalGame);
        hBox2.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(willkommen, info, hBox1, hBox2);
        vBox.setAlignment(Pos.CENTER);
        VBox.setMargin(hBox1, new Insets(140, 0, 30, 0));
        VBox.setMargin(info,  new Insets(35, 0, 0, 0));
        hBox1.setSpacing(30);
        hBox2.setSpacing(30);

        borderPane.setCenter(vBox);
        borderPane.setId("borderpane");
    }

    public Button getFlagGuessing()    { return flagGuessing; }
    public Button getOutlineGuessing() { return outlineGuessing; }
    public Button getFactsGame()       { return factsGame; }
    public Button getHigherLower()     { return higherLower; }
    public Button getCapitalGame()     { return capitalGame; }
    public Text   getWillkommen()      { return willkommen; }
    public Text   getInfo()            { return info; }
    public BorderPane getBorderPane()  { return borderPane; }
}