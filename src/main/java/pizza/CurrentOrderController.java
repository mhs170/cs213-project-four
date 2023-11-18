package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

        //initialize after setting main menu controller
        customInitialize();

    }

    public void customInitialize() {
        Order currentOrder = mainMenuController.getCurrentOrder();
        int num = currentOrder.getOrderNumber();
        ObservableList<Pizza> list = FXCollections.observableList(
                currentOrder.getPizzas()
        );

        orderNumberField.setText(String.valueOf(num));
        orderList.setItems(list);
        updateOrder();
        updateSubtotal();
        updateTax();
        updateTotal();
    }

    @FXML
    void handlePlaceOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(!orderList.getItems().isEmpty()) {
            this.mainMenuController.placeOrder();
            customInitialize();

            alert.setTitle("Placed order");
            alert.setContentText("Successfully placed the order.");
        } else {
            alert.setTitle("Order empty");
            alert.setContentText("Cannot place order, it has no pizzas.");
        }

        alert.show();
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
        updateSubtotal();
        updateTax();
        updateTotal();
    }

    private void updateSubtotal() {
        double subtotal = this.mainMenuController.getCurrentOrder().getSubtotal();
        subtotalField.setText(String.format("%.2f", subtotal));
    }
    private void updateTax() {
        double tax = this.mainMenuController.getCurrentOrder().getSalesTax();
        salesTaxField.setText(String.format("%.2f", tax));
    }
    private void updateTotal() {
        double total = this.mainMenuController.getCurrentOrder().getTotal();
        orderTotalField.setText(String.format("%.2f", total));
    }
}
