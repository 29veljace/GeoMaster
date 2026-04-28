package App;

import View.FlagGameView;
import View.MainMenuView;
import controller.MainMenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeoTriviaApp extends Application {
    // einstiegspunkt
    // scenemanager initalisation
    // hauptmenü


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        MainMenuView mainMenuView = new MainMenuView();
        FlagGameView flagGameView = new FlagGameView();
        MainMenuController mainMenuController = new MainMenuController(mainMenuView);

        Scene mainScene = new Scene(mainMenuView.getBorderPane());

        mainScene.getStylesheets().addAll(getClass().getResource("/css/style.css").toExternalForm());

        stage.setScene(mainScene);
        stage.setMaximized(true);
        stage.setTitle("Geomaster");
        stage.show();
    }
}
