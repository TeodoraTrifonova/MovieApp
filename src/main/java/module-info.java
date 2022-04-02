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
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    //add hibernate exports

    opens bg.tu.varna.sit.movieproject.entities to org.hibernate.orm.core;
    exports bg.tu.varna.sit.movieproject.entities;

    opens bg.tu.varna.sit.movieproject.access to org.hibernate.orm.core;
    exports  bg.tu.varna.sit.movieproject.access;

    exports bg.tu.varna.sit.movieproject.models;
    opens  bg.tu.varna.sit.movieproject.models to javafx.base;

    opens bg.tu.varna.sit.movieproject to javafx.fxml;

    exports bg.tu.varna.sit.movieproject.application;
    opens bg.tu.varna.sit.movieproject.application to javafx.fxml;

    exports bg.tu.varna.sit.movieproject.controllers;
    opens bg.tu.varna.sit.movieproject.controllers to javafx.fxml;
}