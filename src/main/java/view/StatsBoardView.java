package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util.HighScoreManager;
import util.LanguageManager;

/**
 * Statsboard: Highscores der vier Modi plus Win Count und Streaks des Facts-Games.
 * refresh() liest Werte und Sprache neu ein; aufrufen, bevor die View angezeigt wird.
 */
public class StatsBoardView {

    private static final String TITLE_STYLE =
            "-fx-font-size: 40px; -fx-font-weight: bold; -fx-text-fill: whitesmoke;";
    private static final String HEADER_STYLE =
            "-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: whitesmoke;";
    private static final String ROW_STYLE =
            "-fx-font-size: 20px; -fx-text-fill: whitesmoke;";
    private static final String VALUE_STYLE =
            "-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: whitesmoke;";

    private final HBox root;
    private final Button backButton = new Button();

    private final Label titleLabel = new Label();
    private final Label highscoresHeader = new Label();
    private final Label factsHeader = new Label();

    private final Label[] modeNames = new Label[4];
    private final Label[] modeScores = new Label[4];
    private final Label[] factsNames = new Label[3];
    private final Label[] factsValues = new Label[3];

    public StatsBoardView() {
        titleLabel.setStyle(TITLE_STYLE);
        highscoresHeader.setStyle(HEADER_STYLE);
        factsHeader.setStyle(HEADER_STYLE);

        GridPane highscoreGrid = createGrid(modeNames, modeScores);
        GridPane factsGrid = createGrid(factsNames, factsValues);

        backButton.setId("gameOverButton");

        VBox content = new VBox(25,
                titleLabel,
                highscoresHeader, highscoreGrid,
                factsHeader, factsGrid,
                backButton);
        content.setAlignment(Pos.CENTER);

        root = new HBox(content);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #5b9bd5, #3878b8);");

        refresh();
    }

    private GridPane createGrid(Label[] names, Label[] values) {
        GridPane grid = new GridPane();
        grid.setHgap(60);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        ColumnConstraints nameColumn = new ColumnConstraints();
        nameColumn.setMinWidth(280);
        ColumnConstraints valueColumn = new ColumnConstraints();
        valueColumn.setMinWidth(80);
        valueColumn.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().addAll(nameColumn, valueColumn);

        for (int i = 0; i < names.length; i++) {
            names[i] = new Label();
            names[i].setStyle(ROW_STYLE);
            values[i] = new Label();
            values[i].setStyle(VALUE_STYLE);
            grid.add(names[i], 0, i);
            grid.add(values[i], 1, i);
        }
        return grid;
    }

    /** Liest Sprache und Werte neu ein. */
    public void refresh() {
        boolean en = LanguageManager.getLanguage().equals("en");

        titleLabel.setText(en ? "Statistics" : "Statistiken");
        highscoresHeader.setText("Highscores");
        factsHeader.setText(en ? "Four Facts - One Country" : "Vier Fakten - ein Land");
        backButton.setText(en ? "Back to Main Menu" : "Zurück zum Hauptmenü");

        String[] modeLabels = en
                ? new String[]{"Guess the Flag", "Guess the Capital", "Guess the Outline", "Higher or Lower"}
                : new String[]{"Flaggen erraten", "Hauptstädte erraten", "Länderumrisse erraten", "Higher or Lower"};
        int[] scores = {
                HighScoreManager.getFlagHighScore(),
                HighScoreManager.getCapitalHighScore(),
                HighScoreManager.getOutlineHighScore(),
                HighScoreManager.getHLHighScore()
        };
        for (int i = 0; i < modeNames.length; i++) {
            modeNames[i].setText(modeLabels[i]);
            modeScores[i].setText(String.valueOf(scores[i]));
        }

        String[] factsLabels = en
                ? new String[]{"Wins", "Current streak", "Longest streak"}
                : new String[]{"Siege", "Aktuelle Serie", "Längste Serie"};
        int[] factsData = {
                HighScoreManager.getFactsWinCount(),
                HighScoreManager.getFactsCurrentStreak(),
                HighScoreManager.getFactsLongestStreak()
        };
        for (int i = 0; i < factsNames.length; i++) {
            factsNames[i].setText(factsLabels[i]);
            factsValues[i].setText(String.valueOf(factsData[i]));
        }
    }

    public HBox getRoot() {
        return root;
    }

    public Button getBackButton() {
        return backButton;
    }
}