package util;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public final class ErrorDialog {

    private static final Path LOG_FILE =
            Paths.get(System.getProperty("user.home"), ".geomaster", "error.log");

    private ErrorDialog() {
    }

    public static void show(String context, Throwable throwable) {
        String trace = stackTraceOf(throwable);
        writeLog(context, trace);
        if (Platform.isFxApplicationThread()) {
            display(context, throwable, trace);
        } else {
            Platform.runLater(() -> display(context, throwable, trace));
        }
    }

    public static void install() {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
                show("Unhandled exception in thread " + thread.getName(), throwable));
    }

    private static void display(String context, Throwable throwable, String trace) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("GeoMaster – Error");
        alert.setHeaderText(context);
        alert.setContentText(throwable.getClass().getSimpleName() + ": " + throwable.getMessage()
        + "\nOpen an issue at https://github.com/29veljace/GeoMaster/issues and provide the contents of error.log, as well as the actions taken to produce the error");

        TextArea area = new TextArea(trace);
        area.setEditable(false);
        area.setWrapText(false);
        area.setMaxWidth(Double.MAX_VALUE);
        area.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(area, Priority.ALWAYS);
        GridPane.setHgrow(area, Priority.ALWAYS);

        GridPane pane = new GridPane();
        pane.setMaxWidth(Double.MAX_VALUE);
        pane.add(new Label("Stacktrace (Log: " + LOG_FILE + "):"), 0, 0);
        pane.add(area, 0, 1);

        alert.getDialogPane().setExpandableContent(pane);
        alert.showAndWait();
    }

    private static String stackTraceOf(Throwable throwable) {
        StringWriter writer = new StringWriter();
        throwable.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

    private static void writeLog(String context, String trace) {
        try {
            Files.createDirectories(LOG_FILE.getParent());
            String entry = LocalDateTime.now() + " | " + context + System.lineSeparator()
                    + trace + System.lineSeparator();
            Files.writeString(LOG_FILE, entry,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ignored) {
        }
    }
}