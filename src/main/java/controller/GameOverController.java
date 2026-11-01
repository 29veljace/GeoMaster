package controller;

import util.LanguageManager;
import view.GameOverView;
import util.HighScoreManager;
import util.SceneManager;
import util.GameSession;
import model.GameMode;

public class GameOverController {
    public GameOverController(GameOverView gameOverView) {
        int currentScore = GameSession.getCurrentScore();
        GameMode mode = GameSession.getCurrentMode();

        int highScore = getHighScoreForMode(mode);
        double averageScore = getAverageScoreForMode(mode);

        gameOverView.setMode(mode);

        gameOverView.getScoreText().setText("Score: " + currentScore);
        gameOverView.getHighScoreText().setText("High Score: " + highScore);
        if (LanguageManager.getLanguage().equals("en")) {
            gameOverView.getAvgScoreText().setText(String.format("Average Score: %.1f", averageScore));
        }
        else{
            gameOverView.getAvgScoreText().setText(String.format("Durchschnittlicher Score: %.1f", averageScore));
        }


        gameOverView.getReturnMenu().setOnAction(_ -> SceneManager.switchView(GameMode.MAIN_MENU));
    }

    private int getHighScoreForMode(GameMode mode) {
        return switch (mode) {
            case FLAG_GAME -> HighScoreManager.getFlagHighScore();
            case CAPITAL_GAME -> HighScoreManager.getCapitalHighScore();
            case HIGHER_LOWER -> HighScoreManager.getHLHighScore();
            case OUTLINE_GAME -> HighScoreManager.getOutlineHighScore();
            default -> 0;
        };
    }

    private double getAverageScoreForMode(GameMode mode) {
        return switch (mode) {
            case FLAG_GAME -> HighScoreManager.getFlagAverageScore();
            case CAPITAL_GAME -> HighScoreManager.getCapitalAverageScore();
            case HIGHER_LOWER -> HighScoreManager.getHLAverageScore();
            case OUTLINE_GAME -> HighScoreManager.getOutlineAverageScore();
            default -> 0;
        };
    }
}