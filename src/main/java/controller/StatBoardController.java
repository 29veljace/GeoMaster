package controller;

import javafx.stage.Stage;
import model.GameMode;
import util.SceneManager;
import view.StatsBoardView;

public class StatBoardController {
    private StatsBoardView view;
    private Stage stage;

    public StatBoardController(StatsBoardView view) {
        this.view = view;
        initEvents();
    }

    public void initEvents(){
        view.getBackButton().setOnMouseClicked(_ -> SceneManager.switchView(GameMode.MAIN_MENU));
    }
}
