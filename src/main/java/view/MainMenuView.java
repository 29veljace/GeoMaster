package view;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class MainMenuView {
    public static Button flagGuessing;
    public static Button outlineGuessing;
    public static Button factsGame;
    public static Button higherLower;
    public static Button capitalGame;
    public static Button languageButton;
    public static Text welcome;
    public static Text info;
    public ImageView exit;
    private BorderPane borderPane = new BorderPane();

    public MainMenuView() {
        if (util.LanguageManager.getLanguage().equals("en")) {
            flagGuessing = new Button("Guess the Flag");
            outlineGuessing = new Button("Guess the Outline");
            factsGame = new Button("Many Facts → One Country");
            higherLower = new Button("Higher or Lower");
            capitalGame = new Button("Guess the Capital");
            languageButton = new Button("Switch language");
        } else {
            flagGuessing = new Button("Flaggen erraten");
            outlineGuessing = new Button("Länderumrisse erraten");
            factsGame = new Button("Viele Fakten → Ein Land");
            higherLower = new Button("Higher or Lower");
            capitalGame = new Button("Hauptstädte erraten");
            languageButton = new Button("Sprache wechseln");
        }

        flagGuessing.setId("btnFlags");
        outlineGuessing.setId("btnOutline");
        factsGame.setId("btnFacts");
        higherLower.setId("btnHigherLower");
        capitalGame.setId("btnCapital");
        languageButton.setId("btnLanguage");

        welcome = new Text("GeoMaster");
        welcome.setFill(Color.WHITESMOKE);
        welcome.setId("willkommen");

        if (util.LanguageManager.getLanguage().equals("en")) {
            info = new Text("Choose one of the game modes");
        } else {
            info = new Text("Wählen sie einen der Spielmodi");
        }

        info.setFill(Color.WHITESMOKE);
        info.setId("info");

        HBox hBox1 = new HBox(flagGuessing, outlineGuessing);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(higherLower, factsGame, capitalGame);
        hBox2.setAlignment(Pos.CENTER);

        exit = new ImageView(new Image(getClass().getResourceAsStream("/img/exit.png")));
        exit.setFitWidth(60);
        exit.setFitHeight(60);
        exit.setCursor(javafx.scene.Cursor.HAND);
        exit.setPreserveRatio(true);

        VBox vBox = new VBox(welcome, info, hBox1, hBox2);
        vBox.setAlignment(Pos.CENTER);
        VBox.setMargin(hBox1, new Insets(140, 0, 30, 0));
        VBox.setMargin(info, new Insets(35, 0, 0, 0));
        hBox1.setSpacing(30);
        hBox2.setSpacing(30);

        HBox topBar = new HBox(15, languageButton, exit);
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(15, 15, 0, 0));

        borderPane.setTop(topBar);
        borderPane.setCenter(vBox);
        borderPane.setId("borderpane");
    }

    public Button getFlagGuessing() {
        return flagGuessing;
    }

    public Button getOutlineGuessing() {
        return outlineGuessing;
    }

    public Button getFactsGame() {
        return factsGame;
    }

    public Button getHigherLower() {
        return higherLower;
    }

    public Button getCapitalGame() {
        return capitalGame;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public Button getLanguageButton() {
        return languageButton;
    }

    public static void reload() {
        if (util.LanguageManager.getLanguage().equals("en")) {
            flagGuessing.setText("Guess the Flag");
            outlineGuessing.setText("Guess the Outline");
            factsGame.setText("Many Facts → One Country");
            higherLower.setText("Higher or Lower");
            capitalGame.setText("Guess the Capital");
            languageButton.setText("Switch language");
            info.setText("Choose one of the game modes");
        } else {
            flagGuessing.setText("Flaggen erraten");
            outlineGuessing.setText("Länderumrisse erraten");
            factsGame.setText("Viele Fakten → Ein Land");
            higherLower.setText("Higher or Lower");
            capitalGame.setText("Hauptstädte erraten");
            languageButton.setText("Sprache wechseln");
            info.setText("Wählen sie einen der Spielmodi");
        }
    }
}