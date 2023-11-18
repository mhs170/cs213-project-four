package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    private MainMenuController mainMenuController;

    @FXML
    private ListView<Pizza> orderList;

    @FXML
    private TextField orderNumberField;

    @FXML
    private TextField orderTotalField;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button removePizzaButton;

    @FXML
    private TextField salesTaxField;

    @FXML
    private TextField subtotalField;

    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;

        Order currentOrder = mainMenuController.getCurrentOrder();
        int num = currentOrder.getOrderNumber();
        ObservableList<Pizza> list = FXCollections.observableList(
                currentOrder.getPizzas()
        );

        orderNumberField.setText(String.valueOf(num));
        orderList.setItems(list);
    }

    @FXML
    void handlePlaceOrder(ActionEvent event) {

    }

    @FXML
    void handleRemovePizza(ActionEvent event) {
        Pizza pizza = orderList.getSelectionModel().getSelectedItem();
        mainMenuController.removeFromCurrentOrder(pizza);
        updateOrder();
    }

    private void updateOrder() {
        Order currentOrder = mainMenuController.getCurrentOrder();
        ObservableList<Pizza> updatedList = FXCollections.observableList(
                currentOrder.getPizzas()
        );
        orderList.setItems(updatedList);
    }


}
