package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

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

    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;

        customInitialize();
    }

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

    void showOrder(int orderNumber) {
        StoreOrders storeOrders = this.mainMenuController.getStoreOrdersObject();
        ObservableList<Pizza> pizzas = FXCollections.observableList(
                storeOrders.getOrder(orderNumber).getPizzas()
        );
        orderList.setItems(pizzas);
    }

    @FXML
    void handleOrderDropdown(ActionEvent event) {
        Integer orderNumber = orderDropdown.getValue();
        if(orderNumber != null) {
            showOrder(orderNumber);
        }
    }

    @FXML
    void handleCancelOrder(ActionEvent event) {
        int orderNumber = orderDropdown.getValue();
        StoreOrders storeOrders = this.mainMenuController.getStoreOrdersObject();
        storeOrders.removeOrder(storeOrders.getOrder(orderNumber));
        customInitialize();
    }

    @FXML
    void handleExportStoreOrders(ActionEvent event) {

    }

}
