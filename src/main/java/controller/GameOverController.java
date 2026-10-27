package controller;

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

        gameOverView.setMode(mode);

        gameOverView.getScoreText().setText("Score: " + currentScore);
        gameOverView.getHighScoreText().setText("High Score: " + highScore);

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
}
