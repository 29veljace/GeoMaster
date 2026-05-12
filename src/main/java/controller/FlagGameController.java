package controller;

import javafx.scene.image.ImageView;
import model.Country;
import view.FlagGameView;
import model.FlagGameModel;

import java.sql.SQLException;
import java.util.Random;

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
        Country c = flagGameModel.getCountry();
        Country wrong1 = flagGameModel.getCountry();
        Country wrong2 = flagGameModel.getCountry();
        Country wrong3 = flagGameModel.getCountry();
        try {
            flagGameModel.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        flagGameView.getImageView().setImage(c.getFlag());
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i){
            case 0:
                flagGameView.getButton1().setText(c.getName());
                flagGameView.getButton2().setText(wrong1.getName());
                flagGameView.getButton3().setText(wrong2.getName());
                flagGameView.getButton4().setText(wrong3.getName());
            case 1:
                flagGameView.getButton1().setText(wrong1.getName());
                flagGameView.getButton2().setText(c.getName());
                flagGameView.getButton3().setText(wrong2.getName());
                flagGameView.getButton4().setText(wrong3.getName());
            case 2:
                flagGameView.getButton1().setText(wrong1.getName());
                flagGameView.getButton2().setText(wrong2.getName());
                flagGameView.getButton3().setText(c.getName());
                flagGameView.getButton4().setText(wrong3.getName());
            case 3:
                flagGameView.getButton1().setText(wrong1.getName());
                flagGameView.getButton2().setText(wrong2.getName());
                flagGameView.getButton3().setText(wrong3.getName());
                flagGameView.getButton4().setText(c.getName());
        }

    }

    public FlagGameView getFlagGameView() {
        return flagGameView;
    }

    public FlagGameModel getFlagGameModel() {
        return flagGameModel;
    }
}
