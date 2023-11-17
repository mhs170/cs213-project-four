package pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    @FXML
    private ListView<String> orderList;

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

    @FXML
    void handlePlaceOrder(ActionEvent event) {

    }

    @FXML
    void handleRemovePizza(ActionEvent event) {

    }

}
