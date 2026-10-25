package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import model.GameMode;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

public class GameOverView {
    Text gameOverText;
    Text scoreText;
    Text highScoreText;
    Button returnMenu;
    BorderPane borderPane;

    private final Pane texturePane;
    private List<Image> textureImages = List.of();
    private double minOpacity = 0.05;
    private double maxOpacity = 0.15;
    private long textureSeed = 42;

    public GameOverView(Stage stage){
        gameOverText = new Text("Game Over");
        gameOverText.setId("gameOverInfo");
        gameOverText.setFill(Color.WHITESMOKE);

        scoreText = new Text("Score: 0");
        scoreText.setId("gameOverInfo");
        scoreText.setFill(Color.WHITESMOKE);

        highScoreText = new Text("High Score: 0");
        highScoreText.setId("gameOverInfo");
        highScoreText.setFill(Color.WHITESMOKE);

        if (util.LanguageManager.getLanguage().equals("en")) {
            returnMenu = new Button("Back to Main Menu");
        }
        else{
            returnMenu = new Button("Zurück zum Hauptmenü");
        }

        returnMenu.setId("gameOverButton");
        VBox vBox = new VBox(gameOverText,scoreText,highScoreText,returnMenu);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(vBox);
        hBox.setAlignment(Pos.CENTER);

        // Textur-Ebene hinter dem eigentlichen Inhalt
        texturePane = new Pane();
        texturePane.setMouseTransparent(true);

        // Nichts soll über den Rand hinausragen
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(texturePane.widthProperty());
        clip.heightProperty().bind(texturePane.heightProperty());
        texturePane.setClip(clip);

        texturePane.widthProperty().addListener((o, a, b) -> fillTexture());
        texturePane.heightProperty().addListener((o, a, b) -> fillTexture());

        StackPane layered = new StackPane(texturePane, hBox);

        borderPane = new BorderPane();
        borderPane.setCenter(layered);

        setMode(GameMode.GAME_OVER); // Standard: Globus auf Teal, der Controller überschreibt das
    }

    /** Setzt Hintergrund und Textur passend zum verlorenen Spielmodus. */
    public void setMode(GameMode mode) {
        switch (mode) {
            case FLAG_GAME -> applyTheme(
                    "linear-gradient(to bottom right, #3b0a0a, #8b2a2a)",
                    loadRandomImages("/flags", 30), 0.10, 0.22);
            case CAPITAL_GAME -> applyTheme(
                    "linear-gradient(to bottom, #39bdb7, #249d98)",
                    loadSingleImage("/img/city.png"), 0.05, 0.15);
            case OUTLINE_GAME -> applyTheme(
                    "linear-gradient(to bottom right, #e8943a, #c97120)",
                    loadRandomImages("/outlines", 30), 0.10, 0.22);
            case HIGHER_LOWER -> applyTheme(
                    "linear-gradient(to bottom, #7c5cbf, #5e3fa3)",
                    loadSingleImage("/stats.png"), 0.05, 0.15);
            default -> applyTheme(
                    "linear-gradient(to bottom, #0d9488, #042f2e)",
                    loadSingleImage("/img/globe.png"), 0.05, 0.15);
        }
    }

    private void applyTheme(String gradient, List<Image> images, double minOpacity, double maxOpacity) {
        borderPane.setStyle("-fx-background-color: " + gradient + ";");
        this.textureImages = images;
        this.minOpacity = minOpacity;
        this.maxOpacity = maxOpacity;
        this.textureSeed = System.nanoTime(); // pro Game Over neue Anordnung, beim Resize bleibt sie gleich
        fillTexture();
    }

    private void fillTexture() {
        texturePane.getChildren().clear();
        double w = texturePane.getWidth();
        double h = texturePane.getHeight();
        if (w <= 0 || h <= 0 || textureImages.isEmpty()) return;

        Random rnd = new Random(textureSeed);
        double spacing = 70;

        for (double x = 0; x < w + spacing; x += spacing) {
            for (double y = 0; y < h + spacing; y += spacing) {
                ImageView iv = new ImageView(textureImages.get(rnd.nextInt(textureImages.size())));
                double size = 25 + rnd.nextDouble() * 25;                    // 25-50 px
                iv.setFitWidth(size);
                iv.setFitHeight(size);
                iv.setPreserveRatio(true);
                iv.setOpacity(minOpacity + rnd.nextDouble() * (maxOpacity - minOpacity));
                iv.setRotate(rnd.nextDouble() * 360);
                iv.setLayoutX(x + rnd.nextDouble() * 30 - 15);               // leichter Versatz
                iv.setLayoutY(y + rnd.nextDouble() * 30 - 15);
                texturePane.getChildren().add(iv);
            }
        }
    }

    // ---------- Bilder laden ----------

    private static Image loadImage(String path) {
        try (InputStream in = GameOverView.class.getResourceAsStream(path)) {
            if (in == null) {
                System.err.println("Bild nicht gefunden: " + path);
                return null;
            }
            // auf max. 100x100 verkleinert laden, spart Speicher bei großen Flaggen
            Image img = new Image(in, 100, 100, true, true);
            return img.isError() ? null : img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<Image> loadSingleImage(String path) {
        Image img = loadImage(path);
        return img == null ? List.of() : List.of(img);
    }

    /** Lädt zufällig 'count' Bilder aus einem Resource-Ordner. */
    private static List<Image> loadRandomImages(String folder, int count) {
        List<String> files = listResourceFiles(folder);
        Collections.shuffle(files);
        return files.stream()
                .limit(count)
                .map(GameOverView::loadImage)
                .filter(Objects::nonNull)
                .toList();
    }

    /** Listet Bilddateien eines Resource-Ordners (IDE, JAR und jlink-Image). */
    private static List<String> listResourceFiles(String folder) {
        List<String> result = new ArrayList<>();
        try {
            URL url = GameOverView.class.getResource(folder);
            if (url == null) {
                System.err.println("Resource-Ordner nicht gefunden: " + folder);
                return result;
            }
            URI uri = url.toURI();
            if ("jar".equals(uri.getScheme())) {
                FileSystem fs;
                try {
                    fs = FileSystems.newFileSystem(uri, Map.of());
                } catch (FileSystemAlreadyExistsException e) {
                    fs = FileSystems.getFileSystem(uri);
                }
                collectImages(fs.getPath(folder), folder, result); // FS bewusst offen lassen
            } else {
                collectImages(Path.of(uri), folder, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void collectImages(Path dir, String folder, List<String> out) throws IOException {
        try (Stream<Path> files = Files.list(dir)) {
            files.map(p -> p.getFileName().toString())
                    .filter(n -> n.toLowerCase().matches(".*\\.(png|jpe?g|gif)"))
                    .forEach(n -> out.add(folder + "/" + n));
        }
    }

    public BorderPane getBorderPane(){
        return borderPane;
    }

    public Text getGameOverText() {
        return gameOverText;
    }

    public Text getScoreText() {
        return scoreText;
    }

    public Text getHighScoreText() {
        return highScoreText;
    }

    public Button getReturnMenu() {
        return returnMenu;
    }
}