module _2dhif.geomaster {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires javafx.graphics;

    opens app        to javafx.fxml;
    opens controller to javafx.fxml;
    opens model      to javafx.fxml;

    exports app;
    exports controller;
    exports model;
}