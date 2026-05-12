package controller;

import model.Country;
import view.FlagGameView;
import model.FlagGameModel;

public class FlagGameController {
    // controller für das flag game
    private FlagGameView flagGameView;
    private FlagGameModel flagGameModel;

    public FlagGameController(FlagGameView view,FlagGameModel model){
        flagGameView = view;
        flagGameModel = model;
        intEvents();
    }

    public void intEvents(){
        flagGameModel.connect();
        flagGameModel.getData();
        flagGameView.getImageView()
    }

    public FlagGameView getFlagGameView() {
        return flagGameView;
    }

    public FlagGameModel getFlagGameModel() {
        return flagGameModel;
    }
}
