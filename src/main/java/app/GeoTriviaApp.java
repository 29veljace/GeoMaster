package app;

import controller.*;
import javafx.scene.image.Image;
import model.GameMode;
import view.*;
import util.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class GeoTriviaApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SceneManager.init(stage);
        MainMenuView mainMenuView = new MainMenuView();
        new MainMenuController(mainMenuView, stage);
        SceneManager.getScene().getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );
        SceneManager.switchView(GameMode.MAIN_MENU);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setTitle("GeoMaster");
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream("/img/icon.png"))
        );
        stage.show();
    }
}