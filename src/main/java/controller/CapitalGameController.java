package controller;

import model.CapitalGameModel;
import model.Country;
import model.GameMode;
import util.*;
import view.CapitalGameView;
import java.util.Random;

public class CapitalGameController {
    private final CapitalGameModel capitalGameModel;
    private final CapitalGameView capitalGameView;
    private int score = 0;

    public CapitalGameController(CapitalGameView view,CapitalGameModel model){
        capitalGameModel = model;
        capitalGameView = view;
        buildQuestion();
    }
    public void buildQuestion(){
        Country c = capitalGameModel.getNextQuestionCountry();
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
        if (util.LanguageManager.getLanguage().equals("en")){
            capitalGameView.getCapital().setText(c.getCapital_EN());
        }
        else{
            capitalGameView.getCapital().setText(c.getCapital_DE());
        }

        Random random = new Random();
        int i = random.nextInt(4);
        if (util.LanguageManager.getLanguage().equals("en")){
            switch (i) {
                case 0:
                    capitalGameView.getButton1().setText(c.getName_EN());
                    capitalGameView.getButton1().setOnAction(_ -> correctAnswer());

                    capitalGameView.getButton2().setText(wrong1.getName_EN());
                    capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton3().setText(wrong2.getName_EN());
                    capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton4().setText(wrong3.getName_EN());
                    capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 1:
                    capitalGameView.getButton1().setText(wrong1.getName_EN());
                    capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton2().setText(c.getName_EN());
                    capitalGameView.getButton2().setOnAction(_ -> correctAnswer());

                    capitalGameView.getButton3().setText(wrong2.getName_EN());
                    capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton4().setText(wrong3.getName_EN());
                    capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 2:
                    capitalGameView.getButton1().setText(wrong1.getName_EN());
                    capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton2().setText(wrong2.getName_EN());
                    capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton3().setText(c.getName_EN());
                    capitalGameView.getButton3().setOnAction(_ -> correctAnswer());

                    capitalGameView.getButton4().setText(wrong3.getName_EN());
                    capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 3:
                    capitalGameView.getButton1().setText(wrong1.getName_EN());
                    capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton2().setText(wrong2.getName_EN());
                    capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton3().setText(wrong3.getName_EN());
                    capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton4().setText(c.getName_EN());
                    capitalGameView.getButton4().setOnAction(_ -> correctAnswer());
                    break;
            }
        }
        else{
            switch (i) {
                case 0:
                    capitalGameView.getButton1().setText(c.getName_DE());
                    capitalGameView.getButton1().setOnAction(_ -> correctAnswer());

                    capitalGameView.getButton2().setText(wrong1.getName_DE());
                    capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton3().setText(wrong2.getName_DE());
                    capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton4().setText(wrong3.getName_DE());
                    capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 1:
                    capitalGameView.getButton1().setText(wrong1.getName_DE());
                    capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton2().setText(c.getName_DE());
                    capitalGameView.getButton2().setOnAction(_ -> correctAnswer());

                    capitalGameView.getButton3().setText(wrong2.getName_DE());
                    capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton4().setText(wrong3.getName_DE());
                    capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 2:
                    capitalGameView.getButton1().setText(wrong1.getName_DE());
                    capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton2().setText(wrong2.getName_DE());
                    capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton3().setText(c.getName_DE());
                    capitalGameView.getButton3().setOnAction(_ -> correctAnswer());

                    capitalGameView.getButton4().setText(wrong3.getName_DE());
                    capitalGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 3:
                    capitalGameView.getButton1().setText(wrong1.getName_DE());
                    capitalGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton2().setText(wrong2.getName_DE());
                    capitalGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton3().setText(wrong3.getName_DE());
                    capitalGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    capitalGameView.getButton4().setText(c.getName_DE());
                    capitalGameView.getButton4().setOnAction(_ -> correctAnswer());
                    break;
            }
        }
    }

    public void correctAnswer() {
        score++;
        capitalGameView.getScoreNumber().setText(Integer.toString(score));
        buildQuestion();
    }

    public void wrongAnswer() {
        GameSession.setCurrentGame(GameMode.CAPITAL_GAME, score);
        saveHighScore();
        SceneManager.switchView(GameMode.GAME_OVER);
    }

    public void saveHighScore() {
        HighScoreManager.saveCapitalHighScore(score);
        score = 0;
    }
}
