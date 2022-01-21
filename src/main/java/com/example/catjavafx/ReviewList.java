package com.example.catjavafx;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;

public class ReviewList extends Pane {

    protected final ImageView icon;
    protected final Text comment;
    protected final Text date;
    protected final Text rating;
    protected final Text lblrating;


    public ReviewList(String Comment, String Date, String Rating, String Lblrating) {


        icon = new ImageView();
        comment = new Text();
        date = new Text();
        rating = new Text();
        lblrating = new Text();


        setPrefHeight(80.0);
        setPrefWidth(530.0);
        setStyle("-fx-background-color:#FFF; -fx-border-radius: 10px; -fx-background-radius: 10px;");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(3);
        dropShadow.setWidth(3);
        dropShadow.setBlurType(BlurType.TWO_PASS_BOX);
        setEffect(dropShadow);

        try {
            icon.setImage(new Image("https://t4.ftcdn.net/jpg/00/65/77/27/240_F_65772719_A1UV5kLi5nCEWI0BNLLiFaBPEkUbv5Fv.jpg"));
        } catch (Exception e1) {

            e1.printStackTrace();
        }

        icon.setLayoutX(20.0);
        icon.setLayoutY(15.0);
        icon.setFitHeight(50);
        icon.setFitWidth(50);
        icon.setStyle("-fx-border-radius: 50px;");


        date.setLayoutX(100.0);
        date.setLayoutY(25.0);
        date.setText(Date);
        date.setFont(new Font(14.0));

        comment.setLayoutX(100.0);
        comment.setLayoutY(45.0);
        comment.setText(Comment);//store pass parameter
        comment.setFont(new Font(14.0));

        rating.setLayoutX(190.0);
        rating.setLayoutY(70.0);
        rating.setText(Rating);
        rating.setFont(new Font(14.0));


        lblrating.setLayoutX(100.0);
        lblrating.setLayoutY(70.0);
        lblrating.setText("Rating (?/5): ");
        lblrating.setFont(new Font(14.0));



        getChildren().addAll(icon,comment,date,rating,lblrating);

    }
}