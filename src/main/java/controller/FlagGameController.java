package controller;

import model.Country;
import model.GameMode;
import model.GameModel;
import util.*;
import view.FlagGameView;
import java.util.Random;

public class FlagGameController {
    private final FlagGameView flagGameView;
    private final GameModel gameModel;
    private int score = 0;

    public FlagGameController(FlagGameView view, GameModel model) {
        flagGameView = view;
        gameModel = model;
        buildQuestion();
    }

    public void buildQuestion() {
        boolean b = true;
        Country c = gameModel.getNextQuestionCountry();
        Country wrong1 = gameModel.getCountry();
        while (b) {
            b = false;
            if (wrong1.getId() == c.getId()) {
                wrong1 = gameModel.getCountry();
                b = true;
            }
        }
        Country wrong2 = gameModel.getCountry();
        b = true;
        while (b) {
            b = false;
            if (wrong2.getId() == c.getId() || wrong1.getId() == wrong2.getId()) {
                wrong2 = gameModel.getCountry();
                b = true;
            }
        }
        Country wrong3 = gameModel.getCountry();
        b = true;
        while (b) {
            b = false;
            if (wrong3.getId() == c.getId() || wrong3.getId() == wrong2.getId() || wrong3.getId() == wrong1.getId()) {
                wrong3 = gameModel.getCountry();
                b = true;
            }
        }
        flagGameView.getImageView().setImage(c.getFlag());
        Random random = new Random();
        int i = random.nextInt(4);
        if (util.LanguageManager.getLanguage().equals("en")){
            switch (i) {
                case 0:
                    flagGameView.getButton1().setText(c.getName_EN());
                    flagGameView.getButton1().setOnAction(_ -> correctAnswer());

                    flagGameView.getButton2().setText(wrong1.getName_EN());
                    flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton3().setText(wrong2.getName_EN());
                    flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton4().setText(wrong3.getName_EN());
                    flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 1:
                    flagGameView.getButton1().setText(wrong1.getName_EN());
                    flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton2().setText(c.getName_EN());
                    flagGameView.getButton2().setOnAction(_ -> correctAnswer());

                    flagGameView.getButton3().setText(wrong2.getName_EN());
                    flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton4().setText(wrong3.getName_EN());
                    flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 2:
                    flagGameView.getButton1().setText(wrong1.getName_EN());
                    flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton2().setText(wrong2.getName_EN());
                    flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton3().setText(c.getName_EN());
                    flagGameView.getButton3().setOnAction(_ -> correctAnswer());

                    flagGameView.getButton4().setText(wrong3.getName_EN());
                    flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 3:
                    flagGameView.getButton1().setText(wrong1.getName_EN());
                    flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton2().setText(wrong2.getName_EN());
                    flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton3().setText(wrong3.getName_EN());
                    flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton4().setText(c.getName_EN());
                    flagGameView.getButton4().setOnAction(_ -> correctAnswer());
                    break;
            }
        }
        else {
            switch (i) {
                case 0:
                    flagGameView.getButton1().setText(c.getName_DE());
                    flagGameView.getButton1().setOnAction(_ -> correctAnswer());

                    flagGameView.getButton2().setText(wrong1.getName_DE());
                    flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton3().setText(wrong2.getName_DE());
                    flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton4().setText(wrong3.getName_DE());
                    flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 1:
                    flagGameView.getButton1().setText(wrong1.getName_DE());
                    flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton2().setText(c.getName_DE());
                    flagGameView.getButton2().setOnAction(_ -> correctAnswer());

                    flagGameView.getButton3().setText(wrong2.getName_DE());
                    flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton4().setText(wrong3.getName_DE());
                    flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 2:
                    flagGameView.getButton1().setText(wrong1.getName_DE());
                    flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton2().setText(wrong2.getName_DE());
                    flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton3().setText(c.getName_DE());
                    flagGameView.getButton3().setOnAction(_ -> correctAnswer());

                    flagGameView.getButton4().setText(wrong3.getName_DE());
                    flagGameView.getButton4().setOnAction(_ -> wrongAnswer());
                    break;
                case 3:
                    flagGameView.getButton1().setText(wrong1.getName_DE());
                    flagGameView.getButton1().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton2().setText(wrong2.getName_DE());
                    flagGameView.getButton2().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton3().setText(wrong3.getName_DE());
                    flagGameView.getButton3().setOnAction(_ -> wrongAnswer());

                    flagGameView.getButton4().setText(c.getName_DE());
                    flagGameView.getButton4().setOnAction(_ -> correctAnswer());
                    break;
            }
        }
    }

    public void correctAnswer() {
        score++;
        flagGameView.getScoreNumber().setText(Integer.toString(score));
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
