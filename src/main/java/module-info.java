module com.nuwandev.pharmapro {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires spring.jdbc;
    requires java.sql;
    requires flyway.core;
    requires io.github.cdimascio.dotenv.java;
    requires jbcrypt;
    requires java.desktop;

    opens com.nuwandev.pharmapro.app to
            javafx.graphics;
    opens com.nuwandev.pharmapro.ui to
            javafx.fxml;

    exports com.nuwandev.pharmapro.ui;

    opens db.migration;
}
