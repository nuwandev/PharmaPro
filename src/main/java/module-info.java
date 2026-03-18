module com.nuwandev.pharmapro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nuwandev.pharmapro to javafx.fxml;
    exports com.nuwandev.pharmapro;
}