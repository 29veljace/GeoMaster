package controller;

import model.GameMode;
import util.SceneManager;
import view.FactsGameStreakView;

public class FactsGameStreakController {

    FactsGameStreakView view = new FactsGameStreakView();

    public FactsGameStreakController(FactsGameStreakView factsGameStreakView){
        view = factsGameStreakView;
        initEvents();
    }
    public void initEvents(){
        view.getButton().setOnAction(actionEvent -> {
            SceneManager.switchView(GameMode.MAIN_MENU);
        });
    }
}
