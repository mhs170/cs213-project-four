package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Controller for store order view
 * @author Mohammed Salama, Dakshal Panicker
 */
public class StoreOrdersController {

    private MainMenuController mainMenuController;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private ComboBox<Integer> orderDropdown;

    @FXML
    private TextField orderTotalField;

    @FXML
    private ListView<Pizza> orderList;

    /**
     * Set the main controller as a private variable to access its properties
     * @param controller main controller
     */
    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;

        customInitialize();
    }

    /**
     * Initalize that can run as-needed, not automatically
     */
    void customInitialize() {

        StoreOrders storeOrders = this.mainMenuController.getStoreOrdersObject();

        ObservableList<Integer> orderNumbers = FXCollections.observableList(
                storeOrders.getOrderNumbers()
        );

        if(orderNumbers.isEmpty()) {
            orderDropdown.setValue(null);
            orderDropdown.setDisable(true);
            orderList.setItems(null);
            orderList.setDisable(true);
            orderTotalField.setText("00.00");
            cancelOrderButton.setDisable(true);
            exportStoreOrdersButton.setDisable(true);
            exportStoreOrdersButton.setText("There are no orders.");
        }
        else {

            //reset button text

            cancelOrderButton.setDisable(false);
            exportStoreOrdersButton.setDisable(false);
            exportStoreOrdersButton.setText("Export order");

            //initialize order dropdown

            orderDropdown.setDisable(false);
            orderDropdown.setItems(orderNumbers);
            orderDropdown.setOnAction(this::handleOrderDropdown);

            //show first order

            int firstOrderNum = orderNumbers.get(0);
            orderDropdown.setValue(firstOrderNum);

            orderList.setDisable(false);
            showOrder(firstOrderNum);
        }
    }

    /**
     * Display a certain order on the ui base don its order number
     * @param orderNumber order number
     */
    void showOrder(int orderNumber) {
        StoreOrders storeOrders = this.mainMenuController.getStoreOrdersObject();
        Order currOrder = storeOrders.getOrder(orderNumber);
        ObservableList<Pizza> pizzas = FXCollections.observableList(
                currOrder.getPizzas()
        );
        orderList.setItems(pizzas);

        double total = currOrder.getTotal();
        orderTotalField.setText(String.format("%.2f", total));
    }

    /**
     * Handle the order dropdown click
     * @param event unused event
     */
    @FXML
    void handleOrderDropdown(ActionEvent event) {
        Integer orderNumber = orderDropdown.getValue();
        if(orderNumber != null) {
            showOrder(orderNumber);
        }
    }

    /**
     * Handle canceling an event
     * @param event unused event
     */
    @FXML
    void handleCancelOrder(ActionEvent event) {
        int orderNumber = orderDropdown.getValue();
        StoreOrders storeOrders = this.mainMenuController.getStoreOrdersObject();
        storeOrders.removeOrder(storeOrders.getOrder(orderNumber));
        customInitialize();
    }

    /**
     * Handle exporting the orders
     * @param event unused event
     */
    @FXML
    void handleExportStoreOrders(ActionEvent event) throws FileNotFoundException {
        StoreOrders storeOrders = this.mainMenuController.getStoreOrdersObject();
        storeOrders.export();
    }

}
