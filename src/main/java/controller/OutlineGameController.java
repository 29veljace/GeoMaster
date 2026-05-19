package controller;

import model.*;
import util.GameSession;
import util.HighScoreManager;
import util.SceneManager;
import view.OutlineGameView;

import java.sql.SQLException;
import java.util.Random;

public class OutlineGameController {
    private OutlineGameView outlineGameView;
    private OutlineGameModel outlineGameModel;
    private int score;

    public OutlineGameController(OutlineGameView view, OutlineGameModel model){
        outlineGameView = view;
        outlineGameModel = model;
        buildQuestion();
    }

    public void buildQuestion(){
        outlineGameModel.connect();
        boolean b = true;
        Country c = outlineGameModel.getCountry();
        Country wrong1 = outlineGameModel.getCountry();
        while (b) {
            b = false;
            if (wrong1.getId() == c.getId()) {
                wrong1 = outlineGameModel.getCountry();
                b = true;
            }
        }
        Country wrong2 = outlineGameModel.getCountry();
        b = true;
        while (b) {
            b = false;
            if (wrong2.getId() == c.getId() || wrong1.getId() == wrong2.getId()) {
                wrong2 = outlineGameModel.getCountry();
                b = true;
            }
        }
        Country wrong3 = outlineGameModel.getCountry();
        b = true;
        while (b){
            b = false;
            if (wrong3.getId() == c.getId() || wrong3.getId() == wrong2.getId() || wrong3.getId() == wrong1.getId()) {
                wrong3 = outlineGameModel.getCountry();
                b = true;
            }
        }
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
                outlineGameView.getButton1().setOnAction(_ -> correctAnswer());

                outlineGameView.getButton2().setText(wrong1.getName());
                outlineGameView.getButton2().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton3().setText(wrong2.getName());
                outlineGameView.getButton3().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton4().setText(wrong3.getName());
                outlineGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 1:
                outlineGameView.getButton1().setText(wrong1.getName());
                outlineGameView.getButton1().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton2().setText(c.getName());
                outlineGameView.getButton2().setOnAction(_ -> correctAnswer());

                outlineGameView.getButton3().setText(wrong2.getName());
                outlineGameView.getButton3().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton4().setText(wrong3.getName());
                outlineGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 2:
                outlineGameView.getButton1().setText(wrong1.getName());
                outlineGameView.getButton1().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton2().setText(wrong2.getName());
                outlineGameView.getButton2().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton3().setText(c.getName());
                outlineGameView.getButton3().setOnAction(_ -> correctAnswer());

                outlineGameView.getButton4().setText(wrong3.getName());
                outlineGameView.getButton4().setOnAction(_ -> wrongAnswer());
                break;
            case 3:
                outlineGameView.getButton1().setText(wrong1.getName());
                outlineGameView.getButton1().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton2().setText(wrong2.getName());
                outlineGameView.getButton2().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton3().setText(wrong3.getName());
                outlineGameView.getButton3().setOnAction(_ -> wrongAnswer());

                outlineGameView.getButton4().setText(c.getName());
                outlineGameView.getButton4().setOnAction(_ -> correctAnswer());
                break;
        }
    }

    public void correctAnswer(){
        score++;
        buildQuestion();
    }

    public void wrongAnswer(){
        GameSession.setCurrentGame(GameMode.OUTLINE_GAME,score);
        saveHighScore();
        SceneManager.switchView(GameMode.GAME_OVER);
    }

    public void saveHighScore() {
        HighScoreManager.saveOutlineHighScore(score);
        score = 0;
    }

    public OutlineGameView getOutlineGameView() {
        return outlineGameView;
    }

    public OutlineGameModel getOutlineGameModel() {
        return outlineGameModel;
    }
}
