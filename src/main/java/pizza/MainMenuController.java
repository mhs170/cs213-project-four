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
import java.util.List;

public class MainMenuController {

    @FXML
    private Button buildYourOwnButton;

    @FXML
    private Button currOrderButton;

    @FXML
    private Button specialityButton;

    @FXML
    private Button storeOrdersButton;

    private Order currentOrder;

    private StoreOrders storeOrders;

    private StoreOrdersController storeOrderController;
    private CurrentOrderController currentOrderController;

    public void addToCurrentOrder(Pizza pizza) {
        currentOrder.addToOrder(pizza);
        if(currentOrderController != null) {
            currentOrderController.customInitialize();
        }
    }
    public void removeFromCurrentOrder(Pizza pizza){
        currentOrder.removeFromOrder(pizza);
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void placeOrder () {
        storeOrders.addOrder(currentOrder);
        if(storeOrderController != null) {
            storeOrderController.customInitialize();
        }
        currentOrder = new Order();
    }

    public StoreOrders getStoreOrdersObject() {
        return storeOrders;
    }

    @FXML
    void initialize() {
        currentOrder = new Order();
        storeOrders = new StoreOrders();
    }

    @FXML
    void handleSpeciality(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("speciality.fxml"));
            root = loader.load();

            SpecialityController controller = loader.getController();
            controller.setMainMenuController(this);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("build-your-own.fxml"));
            root = loader.load();

            BuildYourOwnController controller = loader.getController();
            controller.setMainMenuController(this);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("current-order.fxml"));
            root = loader.load();

            currentOrderController = loader.getController();
            currentOrderController.setMainMenuController(this);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("store-orders.fxml"));
            root = loader.load();

            storeOrderController = loader.getController();
            storeOrderController.setMainMenuController(this);

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