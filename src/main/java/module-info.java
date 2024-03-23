module sn.dev.ramadanapp2024 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;


    opens sn.dev.ramadanapp2024 to javafx.fxml;
    exports sn.dev.ramadanapp2024;

    exports sn.dev.ramadanapp2024.controller;
    opens sn.dev.ramadanapp2024.controller to javafx.fxml;

    opens sn.dev.ramadanapp2024.entities;



}