package com.example.catjavafx;


import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDateTime;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ReviewController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String textData, rating;

    @FXML
    private ComboBox<String> rating_list;

    @FXML
    private GridPane cardHolder;

    @FXML
    private TextField review;

    ObservableList<ReviewList> list = FXCollections.observableArrayList();
    ArrayList<String> comments = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> ratings = new ArrayList<>();

    getData data = new getData();

    public void switchToMenu(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();;
    }

    public void refresh(ActionEvent event) throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MenuReview.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();;
    }

    @FXML
    private void submitReview(ActionEvent event) throws Exception {
        System.out.println(review.getText());
        if (review.getText().isEmpty() || rating_list.getSelectionModel().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Submit Review");
            alert.setContentText("Please fill in all fields!");
            alert.show();
        } else {
            save();
        }


    }

    public void switchToDetail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DetailAndProgress.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MenuReview.fxml"));
        rating_list.getItems().addAll("1","2","3","4","5");
        //System.out.println("hi");
        try {
            data.getComment(Menu.menu_title, comments);
        } catch (Exception e) {
            e.printStackTrace();
        }//end
        try {
            data.getDate(Menu.menu_title, dates);
        } catch (Exception e) {
            e.printStackTrace();
        }//end
        try {
            data.getRating(Menu.menu_title, ratings);
        } catch (Exception e) {
            e.printStackTrace();
        }//end

        for (int i=0;i<comments.size();i++){
            String str = comments.get(i);
            String date =  dates.get(i);
            String rating =  ratings.get(i);

            list.add(new ReviewList(str, date, rating,"Rating:"));
        }

        cardHolder.setAlignment(Pos.CENTER);
        cardHolder.setVgap(20.00);
        cardHolder.setHgap(20.00);
        cardHolder.setStyle("-fx-padding:10px;-fx-border-color:transparent");
        onSearch();
    }




    class getData{

        String itemID;
        // Get Comment based on 'brand'
        public Review getComment(String menu_title,ArrayList<String> comments) throws Exception {

            //System.out.println("hi");
            String query = "SELECT review FROM cat201.review WHERE menu="+"'"+menu_title+"'";
            Review r = new Review();
            r.menu_title = menu_title;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://194.233.71.124:3306/cat201", "CAT201", "CAT2012022");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(query);

            while(result.next()) {
                String comment = result.getString(1);
                comments.add(comment);//add into array list
            }
            return r;
        }

        public Review getDate(String menu_title,ArrayList<String> dates) throws Exception {


            String query = "SELECT date FROM cat201.review WHERE menu="+"'"+menu_title+"'";
            Review r = new Review();
            r.menu_title = menu_title;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://194.233.71.124:3306/cat201", "CAT201", "CAT2012022");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String date = rs.getString(1);
                dates.add(date);//add into array list
            }
            return r;
        }



        public Review submitData(String menu_title, String textData) throws Exception{
            String query = "SELECT date FROM cat201.review WHERE menu="+"'"+menu_title+"'";
            Review r = new Review();
            r.menu_title = menu_title;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://194.233.71.124:3306/cat201", "CAT201", "CAT2012022");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return r;
        }

        public Review getRating(String menu_title,ArrayList<String> ratings) throws Exception {


            String query = "SELECT rating FROM cat201.review WHERE menu="+"'"+menu_title+"'";
            Review r = new Review();
            r.menu_title = menu_title;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://194.233.71.124:3306/cat201", "CAT201", "CAT2012022");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String rating = rs.getString(1);
                ratings.add(rating);//add into array list
            }
            return r;
        }

    }

    class Review{

        String menu_title;

    }

    private void save() throws Exception{

        textData = review.getText();
        LocalDateTime now = LocalDateTime.now();
        rating = rating_list.getValue().toString();
        String query = "INSERT INTO review (menu, review, rating, date) VALUES ('"+Menu.menu_title+"','"+textData+"','"+rating+"','"+now+"')";
        Review r = new Review();
        r.menu_title = Menu.menu_title;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://194.233.71.124:3306/cat201", "CAT201", "CAT2012022");
        try{
            Statement st = con.createStatement();
            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Your review is submitted successfully!");
            alert.show();

        }catch (SQLException e){
            e.printStackTrace();
        }


        // System.out.println(rs);

    }

    @FXML
    public void onSearch() {
        int count = 0;
        for (int i = 0; i < comments.size(); i++) {
            for (int j = 0; j < 1; j++) {
                cardHolder.add(list.get(count), j, i);
                count++;
            }
        }// end outer for

    }// end fx



}
