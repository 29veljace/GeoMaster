package controller;

import model.Country;
import model.OutlineGameModel;
import view.FlagGameView;
import model.FlagGameModel;
import view.OutlineGameView;

import java.sql.SQLException;
import java.util.Random;

public class OutlineGameController {
    // controller für das flag game
    private OutlineGameView outlineGameView;
    private OutlineGameModel outlineGameModel;

    public OutlineGameController(OutlineGameView view, OutlineGameModel model){
        outlineGameView = view;
        outlineGameModel = model;
        initEvents();
    }

    public void initEvents(){
        outlineGameModel.connect();
        Country c = outlineGameModel.getCountry();
        Country wrong1 = outlineGameModel.getCountry();
        Country wrong2 = outlineGameModel.getCountry();
        Country wrong3 = outlineGameModel.getCountry();
        try {
            outlineGameModel.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        outlineGameView.getImageView().setImage(c.getOutline());
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i){
            case 0:
                outlineGameView.getButton1().setText(c.getName());
                outlineGameView.getButton2().setText(wrong1.getName());
                outlineGameView.getButton3().setText(wrong2.getName());
                outlineGameView.getButton4().setText(wrong3.getName());
            case 1:
                outlineGameView.getButton1().setText(wrong1.getName());
                outlineGameView.getButton2().setText(c.getName());
                outlineGameView.getButton3().setText(wrong2.getName());
                outlineGameView.getButton4().setText(wrong3.getName());
            case 2:
                outlineGameView.getButton1().setText(wrong1.getName());
                outlineGameView.getButton2().setText(wrong2.getName());
                outlineGameView.getButton3().setText(c.getName());
                outlineGameView.getButton4().setText(wrong3.getName());
            case 3:
                outlineGameView.getButton1().setText(wrong1.getName());
                outlineGameView.getButton2().setText(wrong2.getName());
                outlineGameView.getButton3().setText(wrong3.getName());
                outlineGameView.getButton4().setText(c.getName());
        }

    }

    public OutlineGameView getOutlineGameView() {
        return outlineGameView;
    }

    public OutlineGameModel getOutlineGameModel() {
        return outlineGameModel;
    }
}
