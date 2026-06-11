package util;
import java.io.*;
import java.util.Properties;

public class HighScoreManager {

    private static final String PATH = "src/main/resources/highscores.properties";
    private static int countFactsGameStreak = 0;

    public static void saveFlagHighScore(int newScore) {
        Properties props = load();
        int current = Integer.parseInt(props.getProperty("flagGameHighScore", "0"));
        if (newScore > current) {
            props.setProperty("flagGameHighScore", String.valueOf(newScore));
            save(props);
        }
    }

    public static void saveCapitalHighScore(int newScore) {
        Properties props = load();
        int current = Integer.parseInt(props.getProperty("capitalGameHighScore", "0"));
        if (newScore > current) {
            props.setProperty("capitalGameHighScore", String.valueOf(newScore));
            save(props);
        }
    }

    public static void saveFactHighScore(int newScore) {
        Properties props = load();
        int current = Integer.parseInt(props.getProperty("factsGameHighScore", "0"));
        if (newScore > current) {
            props.setProperty("factsGameHighScore", String.valueOf(newScore));
            save(props);
        }
    }

    // HL: Higher/Lower
    public static void saveHLHighScore(int newScore) {
        Properties props = load();
        int current = Integer.parseInt(props.getProperty("higherLowerHighScore", "0"));
        if (newScore > current) {
            props.setProperty("higherLowerHighScore", String.valueOf(newScore));
            save(props);
        }
    }

    public static void saveOutlineHighScore(int newScore) {
        Properties props = load();
        int current = Integer.parseInt(props.getProperty("outlineGameHighScore", "0"));
        if (newScore > current) {
            props.setProperty("outlineGameHighScore", String.valueOf(newScore));
            save(props);
        }
    }

    public static int getFlagHighScore() {
        return Integer.parseInt(load().getProperty("flagGameHighScore", "0"));
    }

    public static int getCapitalHighScore() {
        return Integer.parseInt(load().getProperty("capitalGameHighScore", "0"));
    }

    public static int getFactsHighScore() {
        return Integer.parseInt(load().getProperty("factsGameHighScore", "0"));
    }

    public static int getHLHighScore() {
        return Integer.parseInt(load().getProperty("higherLowerHighScore", "0"));
    }

    public static int getOutlineHighScore() {
        return Integer.parseInt(load().getProperty("outlineGameHighScore", "0"));
    }

    private static Properties load() {
        Properties props = new Properties();
        File file = new File(PATH);
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(file)) {
                props.load(in);
            } catch (IOException e) {
                throw new RuntimeException("Fehler beim Laden der Highscores", e);
            }
        }
        return props;
    }

    private static void save(Properties props) {
        try (FileOutputStream out = new FileOutputStream(PATH)) {
            props.store(out,null);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Speichern der Highscores", e);
        }
    }

    public static void increaseStreak(){
        countFactsGameStreak++;
    }
}