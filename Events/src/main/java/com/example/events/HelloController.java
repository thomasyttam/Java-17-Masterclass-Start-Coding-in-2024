package com.example.events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
    @FXML
    private TextField nameField;

//    @FXML
//    public void onButtonClick() {
//        System.out.println("Hello, " + nameField.getText());
//    }

    @FXML
    public void onButtonClick(ActionEvent e) {
        System.out.println("Hello, " + nameField.getText());
    }
}