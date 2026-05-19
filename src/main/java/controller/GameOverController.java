package controller;

import view.*;
import util.*;
import model.*;

public class GameOverController {
    // controller für game over, zeigt score, blabla

    public GameOverController(GameOverView gameOverView) {
        int currentScore = GameSession.getCurrentScore();
        GameMode mode = GameSession.getCurrentMode();

        int highScore = getHighScoreForMode(mode);

        gameOverView.getScoreText().setText("Score: " + currentScore);
        gameOverView.getHighScoreText().setText("High Score: " + highScore);

        gameOverView.getReturnMenu().setOnAction(_ -> {
            SceneManager.switchView(GameMode.MAIN_MENU);
        });
    }

    private int getHighScoreForMode(GameMode mode) {
        return switch (mode) {
            case FLAG_GAME -> HighScoreManager.getFlagHighScore();
            case CAPITAL_GAME -> HighScoreManager.getCapitalHighScore();
            case FACTS_GAME -> HighScoreManager.getFactsHighScore();
            case HIGHER_LOWER -> HighScoreManager.getHLHighScore();
            case OUTLINE_GAME -> HighScoreManager.getOutlineHighScore();
            default -> 0;
        };
    }
}
