module com.example.mycontacts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mycontacts to javafx.fxml;
    exports com.example.mycontacts;
}