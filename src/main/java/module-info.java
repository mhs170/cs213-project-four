module pizza {
    requires javafx.controls;
    requires javafx.fxml;


    opens pizza to javafx.fxml;
    exports pizza;
}