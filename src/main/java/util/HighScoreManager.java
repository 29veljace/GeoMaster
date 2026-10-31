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

    // highscores
    private static final String COL_HIGHSCORE = "highscore";
    private static final String COL_PLAY_COUNT = "play_count";
    private static final String COL_TOTAL_SCORE = "total_score";

    // facts_stats
    private static final String COL_CURRENT_STREAK = "current_streak";
    private static final String COL_LONGEST_STREAK = "longest_streak";
    private static final String COL_WIN_COUNT = "win_count";
    private static final String COL_GAMES_PLAYED = "games_played";

    static {
        init();
    }

    private HighScoreManager() {
    }

    public static void saveFlagHighScore(int newScore) { recordGame(FLAGS, newScore); }
    public static void saveCapitalHighScore(int newScore) { recordGame(CAPITALS, newScore); }
    public static void saveOutlineHighScore(int newScore) { recordGame(OUTLINES, newScore); }
    public static void saveHLHighScore(int newScore) { recordGame(HIGHER_LOWER, newScore); }

    public static int getFlagHighScore() { return getModeValue(FLAGS, COL_HIGHSCORE); }
    public static int getCapitalHighScore() { return getModeValue(CAPITALS, COL_HIGHSCORE); }
    public static int getOutlineHighScore() { return getModeValue(OUTLINES, COL_HIGHSCORE); }
    public static int getHLHighScore() { return getModeValue(HIGHER_LOWER, COL_HIGHSCORE); }

    public static int getFlagPlayCount() { return getModeValue(FLAGS, COL_PLAY_COUNT); }
    public static int getCapitalPlayCount() { return getModeValue(CAPITALS, COL_PLAY_COUNT); }
    public static int getOutlinePlayCount() { return getModeValue(OUTLINES, COL_PLAY_COUNT); }
    public static int getHLPlayCount() { return getModeValue(HIGHER_LOWER, COL_PLAY_COUNT); }

    public static double getFlagAverageScore() { return getAverageScore(FLAGS); }
    public static double getCapitalAverageScore() { return getAverageScore(CAPITALS); }
    public static double getOutlineAverageScore() { return getAverageScore(OUTLINES); }
    public static double getHLAverageScore() { return getAverageScore(HIGHER_LOWER); }

    private static void recordGame(String mode, int newScore) {
        int score = Math.max(0, newScore);
        String sql = "UPDATE highscores SET "
                + "highscore = MAX(highscore, ?), "
                + "play_count = play_count + 1, "
                + "total_score = total_score + ? "
                + "WHERE mode = ?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, score);
            ps.setInt(2, score);
            ps.setString(3, mode);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving score for " + mode, e);
        }
    }

    private static int getModeValue(String mode, String column) {
        String sql = "SELECT " + column + " FROM highscores WHERE mode = ?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, mode);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading " + column + " for " + mode, e);
        }
    }

    private static double getAverageScore(String mode) {
        String sql = "SELECT total_score, play_count FROM highscores WHERE mode = ?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, mode);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return 0;
                }
                long total = rs.getLong(1);
                int plays = rs.getInt(2);
                return plays == 0 ? 0 : (double) total / plays;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading average score for " + mode, e);
        }
    }

    public static void recordFactsWin() {
        String sql = "UPDATE facts_stats SET "
                + "games_played = games_played + 1, "
                + "win_count = win_count + 1, "
                + "current_streak = current_streak + 1, "
                + "longest_streak = MAX(longest_streak, current_streak + 1) "
                + "WHERE id = 1";
        executeFactsUpdate(sql);
    }

    public static void recordFactsLoss() {
        executeFactsUpdate("UPDATE facts_stats SET "
                + "games_played = games_played + 1, "
                + "current_streak = 0 "
                + "WHERE id = 1");
    }

    public static int getFactsCurrentStreak() { return getFactsValue(COL_CURRENT_STREAK); }
    public static int getFactsLongestStreak() { return getFactsValue(COL_LONGEST_STREAK); }
    public static int getFactsWinCount() { return getFactsValue(COL_WIN_COUNT); }
    public static int getFactsPlayCount() { return getFactsValue(COL_GAMES_PLAYED); }

    /** Win Percentage in Prozent (0.0 - 100.0), 0 wenn noch nie gespielt. */
    public static double getFactsWinPercentage() {
        int played = getFactsPlayCount();
        return played == 0 ? 0 : 100.0 * getFactsWinCount() / played;
    }

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
                        + "highscore INTEGER NOT NULL DEFAULT 0, "
                        + "play_count INTEGER NOT NULL DEFAULT 0, "
                        + "total_score INTEGER NOT NULL DEFAULT 0)");
                st.execute("CREATE TABLE IF NOT EXISTS facts_stats ("
                        + "id INTEGER PRIMARY KEY CHECK (id = 1), "
                        + "current_streak INTEGER NOT NULL DEFAULT 0, "
                        + "longest_streak INTEGER NOT NULL DEFAULT 0, "
                        + "win_count INTEGER NOT NULL DEFAULT 0, "
                        + "games_played INTEGER NOT NULL DEFAULT 0)");

                addColumnIfMissing(c, "highscores", COL_PLAY_COUNT, "INTEGER NOT NULL DEFAULT 0");
                addColumnIfMissing(c, "highscores", COL_TOTAL_SCORE, "INTEGER NOT NULL DEFAULT 0");
                addColumnIfMissing(c, "facts_stats", COL_GAMES_PLAYED, "INTEGER NOT NULL DEFAULT 0");

                st.execute("INSERT OR IGNORE INTO facts_stats (id) VALUES (1)");
                st.execute("INSERT OR IGNORE INTO highscores (mode) VALUES "
                        + "('" + FLAGS + "'), ('" + CAPITALS + "'), "
                        + "('" + OUTLINES + "'), ('" + HIGHER_LOWER + "')");

                st.execute("UPDATE facts_stats SET games_played = MAX(games_played, win_count) WHERE id = 1");
            }
            migrateOldProperties();
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Error initializing user data", e);
        }
    }

    private static void addColumnIfMissing(Connection c, String table, String column, String definition)
            throws SQLException {
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("PRAGMA table_info(" + table + ")")) {
            while (rs.next()) {
                if (column.equalsIgnoreCase(rs.getString("name"))) {
                    return;
                }
            }
        }
        try (Statement st = c.createStatement()) {
            st.execute("ALTER TABLE " + table + " ADD COLUMN " + column + " " + definition);
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