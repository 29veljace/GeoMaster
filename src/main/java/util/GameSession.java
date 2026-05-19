package util;

import model.GameMode;

public class GameSession {
    private static int currentScore = 0;
    private static GameMode currentMode = null;

    public static void setCurrentGame(GameMode mode, int score) {
        currentMode = mode;
        currentScore = score;
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public static GameMode getCurrentMode() {
        return currentMode;
    }
}