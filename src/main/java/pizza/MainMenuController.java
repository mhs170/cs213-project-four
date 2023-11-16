package pizza;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button buildYourOwnButton;

    @FXML
    private Button currOrderButton;

    @FXML
    private Button specialityButton;

    @FXML
    private Button storeOrdersButton;
    @FXML
    void handleSpeciality(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("speciality.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Order Speciality Pizzas");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBuildYourOwn(ActionEvent event) {

    }

    @FXML
    void handleCurrOrder(ActionEvent event) {

    }

    @FXML
    void handleStoreOrders(ActionEvent event) {

    }

}