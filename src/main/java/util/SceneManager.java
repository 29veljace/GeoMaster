package util;

import controller.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.*;
import view.*;

public class SceneManager {
    private static Stage stage;
    private static StackPane root;
    private static Scene scene;

    public static void init(Stage primaryStage) {
        stage = primaryStage;
        root = new StackPane();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void switchView(GameMode mode) {
        switch (mode) {
            case MAIN_MENU -> {
                MainMenuView view = new MainMenuView();
                new MainMenuController(view, stage);
                root.getChildren().setAll(view.getBorderPane());
            }
            case FLAG_GAME -> {
                FlagGameView view = new FlagGameView();
                new FlagGameController(view, new FlagGameModel());
                root.getChildren().setAll(view.getBorderPane());
            }
            case FACTS_GAME -> {
                FactsGameView view = new FactsGameView(stage);
                new FactsGameController();
                root.getChildren().setAll(view.getBorderPane());
            }
            case HIGHER_LOWER -> {
                HigherLowerView view = new HigherLowerView(stage);
                new HigherLowerController();
                root.getChildren().setAll(view.getBorderPane());
            }
            case OUTLINE_GAME -> {
                OutlineGameView view = new OutlineGameView();
                new OutlineGameController(view, new OutlineGameModel());
                root.getChildren().setAll(view.getBorderPane());
            }
            case GAME_OVER -> {
                GameOverView view = new GameOverView(stage);
                new GameOverController(view);
                root.getChildren().setAll(view.getBorderPane());
            }
        }
    }

    public static Scene getScene() {
        return scene;
    }
}