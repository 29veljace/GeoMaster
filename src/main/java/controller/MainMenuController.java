package controller;

import View.FlagGameView;
import View.MainMenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
    // modusauswahl, startet das spiel
    private MainMenuView mainMenuView;
    private Stage stage;
    private FlagGameView flagGameView = new FlagGameView();
    private FlagGameController flagGameController = new FlagGameController(flagGameView);
    public MainMenuController(MainMenuView menuView, Stage stage){
        mainMenuView = menuView;
        this.stage = stage;
        initEvents();
    }
    public void initEvents(){
        mainMenuView.getSpiel1().setOnAction(actionEvent -> {
                stage.setScene(new Scene(flagGameView));
        });
    }
}
