package controller;

import model.*;
import util.*;
import view.CapitalGameView;

import java.sql.SQLException;
import java.util.Random;

public class CapitalGameController {
    private CapitalGameModel capitalGameModel;
    private CapitalGameView capitalGameView;
    private int score = 0;

    public CapitalGameController(CapitalGameView view,CapitalGameModel model){
        capitalGameModel = model;
        capitalGameView = view;
        buildQuestion();
    }
    public void buildQuestion(){
        capitalGameModel.connect();
        Country c = capitalGameModel.getCountry();
        Country wrong1 = capitalGameModel.getCountry();
        boolean b = true;
        while (b) {
            b = false;
            if (wrong1.getId() == c.getId()) {
                wrong1 = capitalGameModel.getCountry();
                b = true;
            }
        }
        Country wrong2 = capitalGameModel.getCountry();
        b = true;
        while (b) {
            b = false;
            if (wrong2.getId() == c.getId() || wrong1.getId() == wrong2.getId()) {
                wrong2 = capitalGameModel.getCountry();
                b = true;
            }
        }
        Country wrong3 = capitalGameModel.getCountry();
        b = true;
        while (b){
            b = false;
            if (wrong3.getId() == c.getId() || wrong3.getId() == wrong2.getId() || wrong3.getId() == wrong1.getId()) {
                wrong3 = capitalGameModel.getCountry();
                b = true;
            }
        }
        try {
            capitalGameModel.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        capitalGameView.getCapital().setText(c.getCapital());
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i) {
            case 0:
                capitalGameView.getButton1().setText(c.getName());
                capitalGameView.getButton1().setOnAction(_ -> correctAnswer());

                capitalGameView.getButton2().setText(wrong1.getName());
                capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton3().setText(wrong2.getName());
                capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton4().setText(wrong3.getName());
                capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 1:
                capitalGameView.getButton1().setText(wrong1.getName());
                capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton2().setText(c.getName());
                capitalGameView.getButton2().setOnAction(_ -> correctAnswer());

                capitalGameView.getButton3().setText(wrong2.getName());
                capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton4().setText(wrong3.getName());
                capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 2:
                capitalGameView.getButton1().setText(wrong1.getName());
                capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton2().setText(wrong2.getName());
                capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton3().setText(c.getName());
                capitalGameView.getButton3().setOnAction(_ -> correctAnswer());

                capitalGameView.getButton4().setText(wrong3.getName());
                capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 3:
                capitalGameView.getButton1().setText(wrong1.getName());
                capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton2().setText(wrong2.getName());
                capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton3().setText(wrong3.getName());
                capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                capitalGameView.getButton4().setText(c.getName());
                capitalGameView.getButton4().setOnAction(_ -> correctAnswer());
                break;
        }
    }
    public void correctAnswer() {
        score++;
        capitalGameView.getScoreNumber().setText(Integer.toString(score));
        buildQuestion();
    }

    public void wrongAnswer() {
        GameSession.setCurrentGame(GameMode.FLAG_GAME, score);
        saveHighScore();
        SceneManager.switchView(GameMode.GAME_OVER);
    }

    public void saveHighScore() {
        HighScoreManager.saveFlagHighScore(score);
        score = 0;
    }
}
