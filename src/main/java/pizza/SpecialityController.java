package pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class SpecialityController {
    @FXML
    private Button addToOrderButton;

    @FXML
    private CheckBox extraCheeseCheckbox;

    @FXML
    private CheckBox extraSauceCheckbox;

    @FXML
    private ImageView imageVIew;

    @FXML
    private TextField priceField;

    @FXML
    private TextField sauceField;

    @FXML
    private ComboBox<?> sizeDropdown;

    @FXML
    private ListView<?> toppingsList;

    @FXML
    private ComboBox<?> typeDropdown;

    @FXML
    void handleAddToOrder(ActionEvent event) {

    }
}
