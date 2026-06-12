module com.example.layout {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.layout to javafx.fxml;
    exports com.example.layout;
}