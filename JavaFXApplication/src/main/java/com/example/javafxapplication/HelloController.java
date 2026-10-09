package com.example.javafxapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

//        File file = chooser.showSaveDialog(gridPane.getScene().getWindow()); // chooser new to be FIleChooser, not DirectoryChooser, save file
//        File file = chooser.showOpenDialog(gridPane.getScene().getWindow()); // choose one file only
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow()); // choose multi files

//        if(file != null) {
//            System.out.println(file.getPath());
        if(file != null) {
            for(int i = 0; i < file.size(); i++) {
                System.out.println(file.get(i));
            }
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    @FXML
    public void handleLinkClick() {
//        System.out.println("The link was clicked");
        try {
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}