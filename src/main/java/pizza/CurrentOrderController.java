package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller for current order view
 * @author Mohammed Salama, Dakshal Panicker
 */
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

    /**
     * Set the main controller as a private variable to access its properties
     * @param controller main controller
     */
    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;

        //initialize after setting main menu controller
        customInitialize();

    }

    /**
     * Initialize the inputs. This can be run as-needed, does not run automatically.
     */
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

    /**
     * Handle adding an order to store orders
     * @param event unused event
     */
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

    /**
     * Handle removing a pizza from the order
     * @param event unused event
     */
    @FXML
    void handleRemovePizza(ActionEvent event) {
        Pizza pizza = orderList.getSelectionModel().getSelectedItem();
        mainMenuController.removeFromCurrentOrder(pizza);
        updateOrder();
    }

    /**
     * Update the order in the ui based on the fetched order from main
     * controller
     */
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

    /**
     * Update the subtotal field based on calculated price
     */
    private void updateSubtotal() {
        double subtotal = this.mainMenuController.getCurrentOrder().getSubtotal();
        subtotalField.setText(String.format("%.2f", subtotal));
    }
    /**
     * Update the tax field based on calculated price
     */
    private void updateTax() {
        double tax = this.mainMenuController.getCurrentOrder().getSalesTax();
        salesTaxField.setText(String.format("%.2f", tax));
    }

    /**
     * Update the total field based on calculated price
     */
    private void updateTotal() {
        double total = this.mainMenuController.getCurrentOrder().getTotal();
        orderTotalField.setText(String.format("%.2f", total));
    }
}
