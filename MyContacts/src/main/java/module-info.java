module com.example.mycontacts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.mycontacts to javafx.fxml;
    opens com.example.datamodel to javafx.fxml;

    exports com.example.mycontacts;
    exports com.example.datamodel;
}