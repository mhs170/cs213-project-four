package pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StoreOrdersController {

    private MainMenuController mainMenuController;

    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

    @FXML
    private Button cancelOrderButton;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private ComboBox<String> orderDropdown;

    @FXML
    private TextField orderTotalField;

    @FXML
    private ListView<String> orderList;

    @FXML
    void handleCancelOrder(ActionEvent event) {

    }

    @FXML
    void handleExportStoreOrders(ActionEvent event) {

    }

}
