package com.example.helloworldfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//
//        Label greeting = new Label("Welcome to JavaFX!");
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//        root.getChildren().add(greeting);
//        Scene scene = new Scene(root, 700, 240);

        Scene scene = new Scene(fxmlLoader.load(), 700, 240);
        stage.setTitle("Hello JavaFX!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}