package com.example.javafxapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;

public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    public void initialize() {
//        label.setScaleX(2.0);
//        label.setScaleY(2.0);
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser(); // FileChooser choose the file
//        chooser.showOpenDialog(null); // can open new window but still can close the main java program
//        chooser.showOpenDialog(gridPane.getScene().getWindow());

//        DirectoryChooser chooser = new DirectoryChooser(); // DirectoryChooser choose the folder
//        chooser.showDialog(gridPane.getScene().getWindow());
//        File file = chooser.showDialog(gridPane.getScene().getWindow());
        File file = chooser.showSaveDialog(gridPane.getScene().getWindow()); // chooser new to be FIleChooser, not DirectoryChooser
        if(file != null) {
            System.out.println(file.getPath());
        } else {
            System.out.println("Chooser was cancelled");
        }
    }
}