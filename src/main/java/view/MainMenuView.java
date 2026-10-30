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
    public static Text welcome;
    public static Text info;
    public ImageView exit;
    public ImageView languageIcon;
    public ImageView statsIcon;
    private final ContextMenu languageMenu;
    private final RadioMenuItem englishItem;
    private final RadioMenuItem germanItem;
    private final BorderPane borderPane = new BorderPane();

    public MainMenuView() {
        if (util.LanguageManager.getLanguage().equals("en")) {
            flagGuessing = new Button("Guess the Flag");
            outlineGuessing = new Button("Guess the Outline");
            factsGame = new Button("Many Facts → One Country");
            higherLower = new Button("Higher or Lower");
            capitalGame = new Button("Guess the Capital");
        } else {
            flagGuessing = new Button("Flaggen erraten");
            outlineGuessing = new Button("Länderumrisse erraten");
            factsGame = new Button("Viele Fakten → Ein Land");
            higherLower = new Button("Higher or Lower");
            capitalGame = new Button("Hauptstädte erraten");
        }

        flagGuessing.setId("btnFlags");
        outlineGuessing.setId("btnOutline");
        factsGame.setId("btnFacts");
        higherLower.setId("btnHigherLower");
        capitalGame.setId("btnCapital");

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
        exit.setPickOnBounds(true);
        exit.setPreserveRatio(true);

        statsIcon = new ImageView(new Image(getClass().getResourceAsStream("/img/stats.png")));
        statsIcon.setFitWidth(60);
        statsIcon.setFitHeight(60);
        statsIcon.setCursor(javafx.scene.Cursor.HAND);
        statsIcon.setPreserveRatio(true);
        statsIcon.setPickOnBounds(true);

        languageIcon = new ImageView(new Image(getClass().getResourceAsStream("/img/globe-grn.png")));
        languageIcon.setFitWidth(60);
        languageIcon.setFitHeight(60);
        languageIcon.setPreserveRatio(true);
        languageIcon.setSmooth(true);
        languageIcon.setCursor(javafx.scene.Cursor.HAND);
        languageIcon.setPickOnBounds(true);
        languageIcon.setId("languageIcon");

        englishItem = new RadioMenuItem("English");
        germanItem = new RadioMenuItem("Deutsch");
        ToggleGroup languageGroup = new ToggleGroup();
        englishItem.setToggleGroup(languageGroup);
        germanItem.setToggleGroup(languageGroup);
        languageMenu = new ContextMenu(englishItem, germanItem);
        languageMenu.setOnShowing(_ -> {
            boolean en = util.LanguageManager.getLanguage().equals("en");
            englishItem.setSelected(en);
            germanItem.setSelected(!en);
        });


        VBox vBox = new VBox(welcome, info, hBox1, hBox2);
        vBox.setAlignment(Pos.CENTER);
        VBox.setMargin(hBox1, new Insets(140, 0, 30, 0));
        VBox.setMargin(info, new Insets(35, 0, 0, 0));
        hBox1.setSpacing(30);
        hBox2.setSpacing(30);

        HBox topBar = new HBox(25, statsIcon, languageIcon, exit);
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(15, 25, 0, 0));

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

    public ImageView getLanguageIcon() {
        return languageIcon;
    }

    public ImageView getStatsIcon() {
        return statsIcon;
    }

    public ContextMenu getLanguageMenu() {
        return languageMenu;
    }

    public RadioMenuItem getEnglishItem() {
        return englishItem;
    }

    public RadioMenuItem getGermanItem() {
        return germanItem;
    }

    public static void reload() {
        if (util.LanguageManager.getLanguage().equals("en")) {
            flagGuessing.setText("Guess the Flag");
            outlineGuessing.setText("Guess the Outline");
            factsGame.setText("Many Facts → One Country");
            higherLower.setText("Higher or Lower");
            capitalGame.setText("Guess the Capital");
            info.setText("Choose one of the game modes");
        } else {
            flagGuessing.setText("Flaggen erraten");
            outlineGuessing.setText("Länderumrisse erraten");
            factsGame.setText("Viele Fakten → Ein Land");
            higherLower.setText("Higher or Lower");
            capitalGame.setText("Hauptstädte erraten");
            info.setText("Wählen sie einen der Spielmodi");
        }
    }
}