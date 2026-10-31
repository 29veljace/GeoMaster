package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import util.HighScoreManager;
import util.LanguageManager;

import java.util.Locale;

public class StatsBoardView {

    private static final String NO_DATA = "–";

    private final HBox root;
    private final Button backButton = new Button();

    private final Label titleLabel = new Label();
    private final Label highscoresHeader = new Label();
    private final Label factsHeader = new Label();

    private final Label[] columnHeaders = new Label[3];
    private final Label[] modeNames = new Label[4];
    private final Label[][] modeValues = new Label[4][3];
    private final Label[] factsNames = new Label[5];
    private final Label[] factsValues = new Label[5];

    public StatsBoardView() {
        titleLabel.setId("statsTitleLabel");
        highscoresHeader.setId("highscoresHeader");
        factsHeader.setId("highscoresHeader");

        GridPane highscoreGrid = createModesGrid();
        GridPane factsGrid = createGrid(factsNames, factsValues);

        backButton.setId("gameOverButton");

        VBox content = new VBox(20,
                titleLabel,
                highscoresHeader, highscoreGrid,
                factsHeader, factsGrid,
                backButton);
        content.setAlignment(Pos.CENTER);

        root = new HBox(content);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #269463");

        Image globe = new Image(getClass().getResourceAsStream("/img/globe-wht.png"));

        Region texture = new Region();
        texture.setBackground(new Background(new BackgroundImage(
                globe,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(120, 120, false, false, false, false) // Kachelgröße in px
        )));
        texture.setOpacity(0.08);
        texture.setMouseTransparent(true);
        texture.setManaged(false);

        root.widthProperty().addListener((o, a, w) ->
                texture.resize(w.doubleValue(), root.getHeight()));
        root.heightProperty().addListener((o, a, h) ->
                texture.resize(root.getWidth(), h.doubleValue()));
        root.getChildren().addFirst(texture);

        refresh();
    }

    private GridPane createModesGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(40);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        ColumnConstraints nameColumn = new ColumnConstraints();
        nameColumn.setMinWidth(280);
        grid.getColumnConstraints().add(nameColumn);
        for (int j = 0; j < columnHeaders.length; j++) {
            ColumnConstraints valueColumn = new ColumnConstraints();
            valueColumn.setMinWidth(100);
            valueColumn.setHalignment(HPos.RIGHT);
            grid.getColumnConstraints().add(valueColumn);
        }

        for (int j = 0; j < columnHeaders.length; j++) {
            columnHeaders[j] = new Label();
            columnHeaders[j].setId("statsColumnHeader");
            columnHeaders[j].setOpacity(0.7);
            grid.add(columnHeaders[j], j + 1, 0);
        }

        for (int i = 0; i < modeNames.length; i++) {
            modeNames[i] = new Label();
            modeNames[i].setId("highscoresRow");
            grid.add(modeNames[i], 0, i + 1);
            for (int j = 0; j < columnHeaders.length; j++) {
                modeValues[i][j] = new Label();
                modeValues[i][j].setId("highscoresValue");
                grid.add(modeValues[i][j], j + 1, i + 1);
            }
        }
        return grid;
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
            names[i].setId("highscoresRow");
            values[i] = new Label();
            values[i].setId("highscoresValue");
            grid.add(names[i], 0, i);
            grid.add(values[i], 1, i);
        }
        return grid;
    }

    public void refresh() {
        boolean en = LanguageManager.getLanguage().equals("en");
        Locale locale = en ? Locale.US : Locale.GERMANY;

        titleLabel.setText(en ? "Statistics" : "Statistiken");
        highscoresHeader.setText("Highscores");
        factsHeader.setText(en ? "Four Facts - One Country" : "Vier Fakten - ein Land");
        backButton.setText(en ? "Back to Main Menu" : "Zurück zum Hauptmenü");

        String[] headers = en
                ? new String[]{"Highscore", "Average", "Played"}
                : new String[]{"Highscore", "Ø Score", "Gespielt"};
        for (int j = 0; j < columnHeaders.length; j++) {
            columnHeaders[j].setText(headers[j]);
        }

        String[] modeLabels = en
                ? new String[]{"Guess the Flag", "Guess the Capital", "Guess the Outline", "Higher or Lower"}
                : new String[]{"Flaggen erraten", "Hauptstädte erraten", "Länderumrisse erraten", "Higher or Lower"};
        int[] highscores = {
                HighScoreManager.getFlagHighScore(),
                HighScoreManager.getCapitalHighScore(),
                HighScoreManager.getOutlineHighScore(),
                HighScoreManager.getHLHighScore()
        };
        double[] averages = {
                HighScoreManager.getFlagAverageScore(),
                HighScoreManager.getCapitalAverageScore(),
                HighScoreManager.getOutlineAverageScore(),
                HighScoreManager.getHLAverageScore()
        };
        int[] plays = {
                HighScoreManager.getFlagPlayCount(),
                HighScoreManager.getCapitalPlayCount(),
                HighScoreManager.getOutlinePlayCount(),
                HighScoreManager.getHLPlayCount()
        };
        for (int i = 0; i < modeNames.length; i++) {
            modeNames[i].setText(modeLabels[i]);
            modeValues[i][0].setText(String.valueOf(highscores[i]));
            modeValues[i][1].setText(plays[i] == 0 ? NO_DATA : String.format(locale, "%.1f", averages[i]));
            modeValues[i][2].setText(String.valueOf(plays[i]));
        }

        int factsPlayed = HighScoreManager.getFactsPlayCount();
        String[] factsLabels = en
                ? new String[]{"Games played", "Wins", "Win percentage", "Current streak", "Longest streak"}
                : new String[]{"Gespielt", "Siege", "Siegquote", "Aktuelle Serie", "Längste Serie"};
        String[] factsData = {
                String.valueOf(factsPlayed),
                String.valueOf(HighScoreManager.getFactsWinCount()),
                factsPlayed == 0 ? NO_DATA : String.format(locale, "%.1f %%", HighScoreManager.getFactsWinPercentage()),
                String.valueOf(HighScoreManager.getFactsCurrentStreak()),
                String.valueOf(HighScoreManager.getFactsLongestStreak())
        };
        for (int i = 0; i < factsNames.length; i++) {
            factsNames[i].setText(factsLabels[i]);
            factsValues[i].setText(factsData[i]);
        }
    }

    public HBox getRoot() {
        return root;
    }

    public Button getBackButton() {
        return backButton;
    }
}