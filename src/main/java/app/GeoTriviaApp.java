package app;

import javafx.scene.image.Image;
import view.FlagGameView;
import view.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeoTriviaApp extends Application {
    // einstiegspunkt
    // scenemanager initalisation
    // hauptmenü


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        MainMenuView mainMenuView = new MainMenuView();
        FlagGameView flagGameView = new FlagGameView(stage);
        //MainMenuController mainMenuController = new MainMenuController(mainMenuView, stage);

        Scene mainScene = new Scene(mainMenuView.getBorderPane());
        Scene flagGameScene = new Scene(flagGameView.getBorderPane());

        mainScene.getStylesheets().addAll(getClass().getResource("/css/style.css").toExternalForm());

        stage.setScene(mainScene);
        stage.setMaximized(true);
        stage.setTitle("GeoMaster");
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream("/icon.png"))
        );
        stage.show();
    }
}
