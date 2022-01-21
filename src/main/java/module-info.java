module com.example.catjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.catjavafx to javafx.fxml;
    exports com.example.catjavafx;
}