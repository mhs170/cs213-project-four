package pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuildYourOwnController {

    @FXML
    private Button addToOrderButton;

    @FXML
    private Button addToppingButton;

    @FXML
    private ListView<String> additionalToppingsList;

    @FXML
    private CheckBox extraCheeseCheckbox;

    @FXML
    private CheckBox extraSauceCheckbox;

    @FXML
    private TextField priceField;

    @FXML
    private Button removeToppingButton;

    @FXML
    private ComboBox<String> sauceDropdown;

    @FXML
    private ListView<String> selectedToppingsList;

    @FXML
    private ComboBox<String> sizeDropdown;

    @FXML
    void handleAddToOrder(ActionEvent event) {

    }

    @FXML
    void handleAddTopping(ActionEvent event) {

    }

    @FXML
    void handleExtraCheese(ActionEvent event) {

    }

    @FXML
    void handleExtraSauce(ActionEvent event) {

    }

    @FXML
    void removeTopping(ActionEvent event) {

    }

}
