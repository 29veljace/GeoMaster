package controller;

import model.*;
import util.HighScoreManager;
import util.SceneManager;
import view.FlagGameView;

import java.sql.SQLException;
import java.util.Random;

public class FlagGameController {
    private FlagGameView flagGameView;
    private FlagGameModel flagGameModel;
    private int score = 0;

    public FlagGameController(FlagGameView view, FlagGameModel model) {
        flagGameView = view;
        flagGameModel = model;
        buildQuestion();
    }

    public void buildQuestion() {
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
        score++;
        buildQuestion();
    }

    public void wrongAnswer() {
        saveHighScore();
        SceneManager.switchView(GameMode.GAME_OVER);
    }

    public void saveHighScore() {
        HighScoreManager.saveFlagHighScore(score);
        score = 0;
    }

    public FlagGameView getFlagGameView() {
        return flagGameView;
    }

    public FlagGameModel getFlagGameModel() {
        return flagGameModel;
    }
}
