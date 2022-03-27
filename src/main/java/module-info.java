module bg.tu.varna.sit.movieproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens bg.tu.varna.sit.movieproject to javafx.fxml;
    exports bg.tu.varna.sit.movieproject.application;
    opens bg.tu.varna.sit.movieproject.application to javafx.fxml;
    exports bg.tu.varna.sit.movieproject.controllers;
    opens bg.tu.varna.sit.movieproject.controllers to javafx.fxml;
}