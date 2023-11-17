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
            stage.setScene(new Scene(root, 450, 500));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBuildYourOwn(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("build-your-own.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Customize Your Pizza");
            stage.setScene(new Scene(root, 450, 600));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleCurrOrder(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("current-order.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleStoreOrders(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("store-orders.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}