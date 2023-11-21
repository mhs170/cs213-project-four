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

/**
 * Controller for main menu view
 * @author Mohammed Salama, Dakshal Panicker
 */
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

    /**
     * Add a pizza to the current order and refresh the current order view
     * @param pizza pizza to add
     */
    public void addToCurrentOrder(Pizza pizza) {
        currentOrder.addToOrder(pizza);
        if(currentOrderController != null) {
            currentOrderController.customInitialize();
        }
    }

    /**
     * Remove a pizza from the current order
     * @param pizza pizza to remove
     */
    public void removeFromCurrentOrder(Pizza pizza){
        currentOrder.removeFromOrder(pizza);
    }

    /**
     * Get the current order
     * @return current order private variable
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Place the current order into store orders and refresh the store orders
     * view
     * @author Mohammed Salama, Dakshal Panicker
     */
    public void placeOrder () {
        storeOrders.addOrder(currentOrder);
        if(storeOrderController != null) {
            storeOrderController.customInitialize();
        }
        currentOrder = new Order();
    }

    /**
     * Get the store orders object
     * @return store orders
     */
    public StoreOrders getStoreOrdersObject() {
        return storeOrders;
    }

    /**
     * Initialize main menu view
     * Runs automatically
     */
    @FXML
    void initialize() {
        currentOrder = new Order();
        storeOrders = new StoreOrders();
    }

    /**
     * Handle opening the speciality view
     * @param event unused event
     */
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

    /**
     * Handle opening the build your own view
     * @param event unused event
     */
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

    /**
     * Handle opening the current order view
     * @param event unused event
     */
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

    /**
     * Handle opening the store orders view
     * @param event unused event
     */
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