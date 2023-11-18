package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuildYourOwnController {

    private MainMenuController mainMenuController;

    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

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
    private ComboBox<Sauce> sauceDropdown;

    @FXML
    private ListView<String> selectedToppingsList;

    @FXML
    private ComboBox<Size> sizeDropdown;

    ObservableList<Size> sizes = FXCollections.observableArrayList(
            Size.SMALL, Size.MEDIUM, Size.LARGE
    );

    ObservableList<Sauce> sauces = FXCollections.observableArrayList(
            Sauce.TOMATO, Sauce.ALFREDO
    );
    @FXML
    void initialize(){
        sizeDropdown.setItems(sizes);
        sizeDropdown.getSelectionModel().selectFirst();

        sauceDropdown.setItems(sauces);
        sauceDropdown.getSelectionModel().selectFirst();
    }

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
    public void updatePrice() {
        double price = getPizza().price();
        priceField.setText(String.format("%.2f", price));
    }
    public Pizza getPizza() {
        Pizza pizza = PizzaMaker.createPizza("BuildYourOwn");
        pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
        pizza.setExtraSauce(extraSauceCheckbox.isSelected());
        pizza.setSize(sizeDropdown.getValue());
        return pizza;
    }
}