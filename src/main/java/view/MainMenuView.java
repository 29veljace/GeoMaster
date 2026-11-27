package view;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import util.LanguageManager;

import java.util.Objects;

public class MainMenuView {
    private static final double ICON_SIZE = 60;

    private final Button flagGuessing = new Button();
    private final Button outlineGuessing = new Button();
    private final Button factsGame = new Button();
    private final Button higherLower = new Button();
    private final Button capitalGame = new Button();
    private final Text welcome;
    private final Text info = new Text();
    private final ImageView exit;
    private final ImageView languageIcon;
    private final ImageView statsIcon;
    private final ImageView settingsIcon;
    private final ContextMenu languageMenu;
    private final RadioMenuItem englishItem;
    private final RadioMenuItem germanItem;
    private final BorderPane borderPane = new BorderPane();

    public MainMenuView() {
        flagGuessing.setId("btnFlags");
        outlineGuessing.setId("btnOutline");
        factsGame.setId("btnFacts");
        higherLower.setId("btnHigherLower");
        capitalGame.setId("btnCapital");

        welcome = new Text("GeoMaster");
        welcome.setFill(Color.WHITESMOKE);
        welcome.setId("willkommen");

        applyTexts();

        info.setFill(Color.WHITESMOKE);
        info.setId("info");

        HBox hBox1 = new HBox(flagGuessing, outlineGuessing);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(higherLower, factsGame, capitalGame);
        hBox2.setAlignment(Pos.CENTER);

        exit = createIcon("/img/exit.png", null);
        statsIcon = createIcon("/img/stats.png", null);
        languageIcon = createIcon("/img/globe-grn.png", "languageIcon");
        settingsIcon = createIcon("/img/cog.png", "settingsIcon");

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

        HBox topBar = new HBox(25, settingsIcon, statsIcon, languageIcon, exit);
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(15, 25, 0, 0));

        borderPane.setTop(topBar);
        borderPane.setCenter(vBox);
        borderPane.setId("borderpane");
    }

    public void reload() {
        applyTexts();
    }


    private void applyTexts() {
        flagGuessing.setText(localized("Guess the Flag", "Flaggen erraten"));
        outlineGuessing.setText(localized("Guess the Outline", "Länderumrisse erraten"));
        factsGame.setText(localized("Many Facts → One Country", "Viele Fakten → Ein Land"));
        higherLower.setText("Higher or Lower");
        capitalGame.setText(localized("Guess the Capital", "Hauptstädte erraten"));
        info.setText(localized("Choose one of the game modes", "Wählen Sie einen der Spielmodi"));
    }

    private ImageView createIcon(String resourcePath, String id) {
        String url = Objects.requireNonNull(getClass().getResource(resourcePath)).toExternalForm();
        ImageView icon = new ImageView(new Image(url));
        icon.setFitWidth(ICON_SIZE);
        icon.setFitHeight(ICON_SIZE);
        icon.setPreserveRatio(true);
        icon.setSmooth(true);
        icon.setPickOnBounds(true);
        icon.setCursor(javafx.scene.Cursor.HAND);
        if (id != null) {
            icon.setId(id);
        }
        return icon;
    }

    public Text getWelcome() {
        return welcome;
    }

    public ImageView getSettingsIcon() {
        return settingsIcon;
    }

    public ImageView getExit() {
        return exit;
    }

    public Text getInfo() {
        return info;
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

    private static String localized(String english, String german) {
        return isEnglish() ? english : german;
    }

    private static boolean isEnglish() {
        return LanguageManager.getLanguage().equals("en");
    }
}