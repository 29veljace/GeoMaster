package util;

import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class LanguageManager {

    private static final Path CONFIG_DIR = Paths.get(System.getProperty("user.home"), ".geomaster");

    private static final Path SETTINGS_FILE = CONFIG_DIR.resolve("settings.properties");

    public static String getLanguage() {
        Properties props = load();
        return props.getProperty("language", "en");
    }

    public static void setLanguage(String langCode) {
        Properties props = load();
        props.setProperty("language", langCode);
        save(props);
    }

    public static void switchLanguage() {
        if ("en".equals(getLanguage())) {
            setLanguage("de");
        } else {
            setLanguage("en");
        }
    }

    private static void ensureSettingsFileExists() {
        if (Files.exists(SETTINGS_FILE)) {
            return;
        }

        try {
            Files.createDirectories(CONFIG_DIR);

            try (InputStream in =
                         LanguageManager.class.getResourceAsStream(
                                 "/settings.properties")) {

                if (in == null) {
                    throw new FileNotFoundException(
                            "settings.properties not found in classpath."
                    );
                }
                Files.copy(in, SETTINGS_FILE);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error creating settings", e
            );
        }
    }

    private static Properties load() {
        ensureSettingsFileExists();

        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(SETTINGS_FILE)) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error loading settings", e
            );
        }

        return props;
    }

    private static void save(Properties props) {
        try {
            Files.createDirectories(CONFIG_DIR);

            try (OutputStream out = Files.newOutputStream(SETTINGS_FILE)) {
                props.store(out, null);
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error saving settings", e
            );
        }
    }
}