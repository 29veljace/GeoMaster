package controller;

import View.FlagGameView;
import View.MainMenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FlagGameModel;

public class MainMenuController {
    // modusauswahl, startet das spiel
    private MainMenuView mainMenuView;
    private Stage stage;


    private FlagGameView view = new FlagGameView();
    private FlagGameModel model = new FlagGameModel();
    private FlagGameController controller = new FlagGameController(view,model);

    public MainMenuController(MainMenuView menuView, Stage stage){
        mainMenuView = menuView;
        this.stage = stage;
        initEvents();
    }
    public void initEvents(){
        mainMenuView.getSpiel1().setOnAction(actionEvent -> {
                stage.setScene(new Scene(controller.getFlagGameView()));
        });
    }
}
