package App;

import View.MainMenuView;
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

        Scene scene = new Scene(mainMenuView.getBorderPane());

        scene.getStylesheets().addAll(getClass().getResource("/css/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Geomaster");
        stage.show();
    }
}
