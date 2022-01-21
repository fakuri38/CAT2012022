package com.example.catjavafx;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable{
    public Button palatao, beast, chicken;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> comboBox;

    @FXML


    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Order.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDetail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DetailAndProgress.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void palataoReview(ActionEvent event) throws IOException {
        Menu.menu_title = palatao.getId();
        Parent root = FXMLLoader.load(getClass().getResource("MenuReview.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void beastReview(ActionEvent event) throws IOException {
        Menu.menu_title = beast.getId();
        Parent root = FXMLLoader.load(getClass().getResource("MenuReview.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void chickenReview(ActionEvent event) throws IOException {
        Menu.menu_title = chicken.getId();
        Parent root = FXMLLoader.load(getClass().getResource("MenuReview.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

