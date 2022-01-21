package com.example.catjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu extends Application {

    public static String menu_title;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Bikerz Patty");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }




}
