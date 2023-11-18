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
    private static final double SALES_TAX_PERCENTAGE = 0.06625;

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

    private double calculateSubtotal(){
        double subtotal = 0;
        Order currentOrder = mainMenuController.getCurrentOrder();
        for (Pizza pizza : currentOrder.getPizzas()) {
            subtotal += pizza.price();
        }
        return subtotal;
    }
    private void updateSubtotal() {
        double subtotal = calculateSubtotal();
        subtotalField.setText(String.format("%.2f", subtotal));
    }
    private void updateTax() {
        double tax = calculateSalesTax();
        salesTaxField.setText(String.format("%.2f", tax));
    }
    private void updateTotal() {
        double total = calculateTotal();
        orderTotalField.setText(String.format("%.2f", total));
    }
    private double calculateSalesTax(){
        return SALES_TAX_PERCENTAGE * calculateSubtotal();
    }
    private double calculateTotal(){
        return calculateSalesTax() + calculateSubtotal();
    }
}
