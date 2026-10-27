package util;

import app.Launcher;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseManager {

    private static Connection connection;

    private DatabaseManager() {}

    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                File dbFile = ensureDbFile();
                connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath());
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }

    private static File ensureDbFile() {
        File dbFolder = new File(System.getProperty("user.home"), ".geomaster");
        File dbFile = new File(dbFolder, "countrydata.db");
        if (!dbFolder.exists()) {
            dbFolder.mkdirs();
        }
        if (!dbFile.exists()) {
            try (InputStream is = Launcher.class.getResourceAsStream("/countrydata.db");
                 OutputStream os = new FileOutputStream(dbFile)) {
                if (is == null) {
                    throw new FileNotFoundException("Original countrydata.db file not found in src/main/resources!");
                }
                is.transferTo(os);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return dbFile;
    }
}