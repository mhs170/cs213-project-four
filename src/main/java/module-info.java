module com.example.cs213projectfour {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs213projectfour to javafx.fxml;
    exports com.example.cs213projectfour;
}