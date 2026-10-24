package util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;


public class HighScoreManager {

    private static final Path CONFIG_DIR = Paths.get(System.getProperty("user.home"), ".geomaster");
    private static final Path OLD_FILE = CONFIG_DIR.resolve("highscores.properties");
    private static final Path MIGRATED_FILE = CONFIG_DIR.resolve("highscores.properties.migrated");
    private static final String DB_URL = "jdbc:sqlite:" + CONFIG_DIR.resolve("userdata.db");

    private static final String FLAGS = "flags";
    private static final String CAPITALS = "capitals";
    private static final String OUTLINES = "outlines";
    private static final String HIGHER_LOWER = "higherlower";

    private static final Map<String, String> LEGACY_KEYS = Map.of(
            "flagGameHighScore", FLAGS,
            "capitalGameHighScore", CAPITALS,
            "outlineGameHighScore", OUTLINES,
            "higherLowerHighScore", HIGHER_LOWER
    );

    private static final String COL_CURRENT_STREAK = "current_streak";
    private static final String COL_LONGEST_STREAK = "longest_streak";
    private static final String COL_WIN_COUNT = "win_count";

    static {
        init();
    }

    private HighScoreManager() {
    }


    public static void saveFlagHighScore(int newScore) { saveHighScore(FLAGS, newScore); }
    public static void saveCapitalHighScore(int newScore) { saveHighScore(CAPITALS, newScore); }
    public static void saveOutlineHighScore(int newScore) { saveHighScore(OUTLINES, newScore); }
    public static void saveHLHighScore(int newScore) { saveHighScore(HIGHER_LOWER, newScore); }

    public static int getFlagHighScore() { return getHighScore(FLAGS); }
    public static int getCapitalHighScore() { return getHighScore(CAPITALS); }
    public static int getOutlineHighScore() { return getHighScore(OUTLINES); }
    public static int getHLHighScore() { return getHighScore(HIGHER_LOWER); }

    private static void saveHighScore(String mode, int newScore) {
        String sql = "UPDATE highscores SET highscore = MAX(highscore, ?) WHERE mode = ?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, newScore);
            ps.setString(2, mode);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving High Score for " + mode, e);
        }
    }

    private static int getHighScore(String mode) {
        String sql = "SELECT highscore FROM highscores WHERE mode = ?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, mode);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading High Score for " + mode, e);
        }
    }

    public static void recordFactsWin() {
        String sql = "UPDATE facts_stats SET "
                + "win_count = win_count + 1, "
                + "current_streak = current_streak + 1, "
                + "longest_streak = MAX(longest_streak, current_streak + 1) "
                + "WHERE id = 1";
        executeFactsUpdate(sql);
    }

    public static void recordFactsLoss() {
        executeFactsUpdate("UPDATE facts_stats SET current_streak = 0 WHERE id = 1");
    }

    public static int getFactsCurrentStreak() { return getFactsValue(COL_CURRENT_STREAK); }
    public static int getFactsLongestStreak() { return getFactsValue(COL_LONGEST_STREAK); }
    public static int getFactsWinCount() { return getFactsValue(COL_WIN_COUNT); }

    private static void executeFactsUpdate(String sql) {
        try (Connection c = connect(); Statement st = c.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving Facts stats", e);
        }
    }

    private static int getFactsValue(String column) {
        String sql = "SELECT " + column + " FROM facts_stats WHERE id = 1";
        try (Connection c = connect(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error loading Facts stats", e);
        }
    }


    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private static void init() {
        try {
            Files.createDirectories(CONFIG_DIR);
            try (Connection c = connect(); Statement st = c.createStatement()) {
                st.execute("CREATE TABLE IF NOT EXISTS highscores ("
                        + "mode TEXT PRIMARY KEY, "
                        + "highscore INTEGER NOT NULL DEFAULT 0)");
                st.execute("CREATE TABLE IF NOT EXISTS facts_stats ("
                        + "id INTEGER PRIMARY KEY CHECK (id = 1), "
                        + "current_streak INTEGER NOT NULL DEFAULT 0, "
                        + "longest_streak INTEGER NOT NULL DEFAULT 0, "
                        + "win_count INTEGER NOT NULL DEFAULT 0)");
                st.execute("INSERT OR IGNORE INTO facts_stats (id) VALUES (1)");
                st.execute("INSERT OR IGNORE INTO highscores (mode) VALUES "
                        + "('" + FLAGS + "'), ('" + CAPITALS + "'), "
                        + "('" + OUTLINES + "'), ('" + HIGHER_LOWER + "')");
            }
            migrateOldProperties();
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Error initializing user data", e);
        }
    }

    private static void migrateOldProperties() {
        if (!Files.exists(OLD_FILE)) {
            return;
        }

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(OLD_FILE)) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String sql = "UPDATE highscores SET highscore = MAX(highscore, ?) WHERE mode = ?";
        try (Connection c = connect()) {
            c.setAutoCommit(false);
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                for (Map.Entry<String, String> entry : LEGACY_KEYS.entrySet()) {
                    ps.setInt(1, parseOrZero(props.getProperty(entry.getKey())));
                    ps.setString(2, entry.getValue());
                    ps.executeUpdate();
                }
                c.commit();
            } catch (SQLException e) {
                c.rollback();
                throw e;
            }
            Files.move(OLD_FILE, MIGRATED_FILE, StandardCopyOption.REPLACE_EXISTING);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static int parseOrZero(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return Math.max(0, Integer.parseInt(value.trim()));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}