package com.example.events;

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

    public void onButtonClick() {
        System.out.println("Hello, " + nameField.getText());
    }
}