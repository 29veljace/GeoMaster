package controller;

import model.CapitalGameModel;
import view.CapitalGameView;

public class CapitalGameController {
    // controller für das hauptstadtspiel
    private CapitalGameModel capitalGameModel;
    private CapitalGameView capitalGameView;

    public CapitalGameController(CapitalGameView view,CapitalGameModel model){
        capitalGameModel = model;
        capitalGameView = view;
        buildQuestion();
    }
    public void buildQuestion(){
        capitalGameModel.connect();

    }
}
