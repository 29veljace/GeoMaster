package controller;

import model.*;
import util.SceneManager;
import view.FlagGameView;

import java.sql.SQLException;
import java.util.Random;

public class FlagGameController {
    private FlagGameView flagGameView;
    private FlagGameModel flagGameModel;

    public FlagGameController(FlagGameView view, FlagGameModel model) {
        flagGameView = view;
        flagGameModel = model;
        buildQuestion();
    }

    public void buildQuestion() {
        boolean b = true;
        flagGameModel.connect();
        Country c = flagGameModel.getCountry();
        Country wrong1 = flagGameModel.getCountry();
        while (b) {
            b = false;
            if (wrong1.getId() == c.getId()) {
                wrong1 = flagGameModel.getCountry();
                b = true;
            }
        }
        Country wrong2 = flagGameModel.getCountry();
        b = true;
        while (b) {
            b = false;
            if (wrong2.getId() == c.getId() || wrong1.getId() == wrong2.getId()) {
                wrong2 = flagGameModel.getCountry();
                b = true;
            }
        }
        Country wrong3 = flagGameModel.getCountry();
        b = true;
        while (b){
            b = false;
            if (wrong3.getId() == c.getId() || wrong3.getId() == wrong2.getId() || wrong3.getId() == wrong1.getId()) {
                wrong2 = flagGameModel.getCountry();
                b = true;
            }
        }
        try {
            flagGameModel.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        flagGameView.getImageView().setImage(c.getFlag());
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i) {
            case 0:
                flagGameView.getButton1().setText(c.getName());
                flagGameView.getButton1().setOnAction(_ -> correctAnswer());

                flagGameView.getButton2().setText(wrong1.getName());
                flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton3().setText(wrong2.getName());
                flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton4().setText(wrong3.getName());
                flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 1:
                flagGameView.getButton1().setText(wrong1.getName());
                flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton2().setText(c.getName());
                flagGameView.getButton2().setOnAction(_ -> correctAnswer());

                flagGameView.getButton3().setText(wrong2.getName());
                flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton4().setText(wrong3.getName());
                flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 2:
                flagGameView.getButton1().setText(wrong1.getName());
                flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton2().setText(wrong2.getName());
                flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton3().setText(c.getName());
                flagGameView.getButton3().setOnAction(_ -> correctAnswer());

                flagGameView.getButton4().setText(wrong3.getName());
                flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 3:
                flagGameView.getButton1().setText(wrong1.getName());
                flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton2().setText(wrong2.getName());
                flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton3().setText(wrong3.getName());
                flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                flagGameView.getButton4().setText(c.getName());
                flagGameView.getButton4().setOnAction(_ -> correctAnswer());
                break;
        }

    }

    public void correctAnswer() {
        buildQuestion();
    }

    public void wrongAnswer(){
        SceneManager.switchView(GameMode.GAME_OVER);
    }

    public FlagGameView getFlagGameView() {
        return flagGameView;
    }

    public FlagGameModel getFlagGameModel() {
        return flagGameModel;
    }
}
