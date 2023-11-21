package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 * Controller for build your own pizza view
 * @author Mohammed Salama, Dakshal Panicker
 */
public class BuildYourOwnController {

    private MainMenuController mainMenuController;

    @FXML
    private Button addToOrderButton;

    @FXML
    private Button addToppingButton;

    @FXML
    private ListView<Topping> additionalToppingsList;

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
    private ListView<Topping> selectedToppingsList;

    @FXML
    private ComboBox<Size> sizeDropdown;

    ObservableList<Size> sizes = FXCollections.observableArrayList(
            Size.SMALL, Size.MEDIUM, Size.LARGE
    );

    ObservableList<Sauce> sauces = FXCollections.observableArrayList(
            Sauce.TOMATO, Sauce.ALFREDO
    );

    ObservableList<Topping> possibleToppings = FXCollections.observableArrayList(
            Topping.BLACK_OLIVE,
            Topping.GREEN_PEPPER,
            Topping.MUSHROOM,
            Topping.ONION,
            Topping.PINEAPPLE,
            Topping.PEPPERONI,
            Topping.CHICKEN,
            Topping.HAM,
            Topping.BEEF,
            Topping.SAUSAGE,
            Topping.SQUID,
            Topping.CRAB_MEATS,
            Topping.SHRIMP
    );

    /**
     * Set the main controller as a private variable to access its properties
     * @param controller main controller
     */
    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

    /**
     * Automatically run initialize for controller
     */
    @FXML
    void initialize(){

        //also used to reset the form

        extraCheeseCheckbox.setSelected(false);
        extraSauceCheckbox.setSelected(false);

        sizeDropdown.setItems(sizes);
        sizeDropdown.getSelectionModel().selectFirst();
        sizeDropdown.setOnAction(this::handleSizeDropdown);

        sauceDropdown.setItems(sauces);
        sauceDropdown.getSelectionModel().selectFirst();
        sauceDropdown.setOnAction(this::handleSauceDropdown);

        additionalToppingsList.setItems(FXCollections.observableArrayList(
                possibleToppings
        ));
        selectedToppingsList.getItems().clear();

        updatePrice();
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void handleSizeDropdown(ActionEvent event) {
        updatePrice();
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void handleSauceDropdown(ActionEvent event) {
        updatePrice();
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void handleExtraCheese(ActionEvent event) {
        updatePrice();
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void handleExtraSauce(ActionEvent event) {
        updatePrice();
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void handleAddTopping(ActionEvent event) {
        Topping selectedTopping = additionalToppingsList.getSelectionModel().getSelectedItem();

        if(selectedTopping == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No toppings selected");
            alert.setContentText("Select a topping to add it.");
            alert.show();
        }
        else if(selectedToppingsList.getItems().size() == 7) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cannot add another topping");
            alert.setContentText("You can have at most 7 toppings.");
            alert.show();

        } else {
            ObservableList<Topping> list1 = additionalToppingsList.getItems();
            ObservableList<Topping> list2 = selectedToppingsList.getItems();
            list1.remove(selectedTopping);
            list2.add(selectedTopping);

            additionalToppingsList.setItems(list1);
            selectedToppingsList.setItems(list2);
            updatePrice();
        }
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void removeTopping(ActionEvent event) {
        Topping selectedTopping = selectedToppingsList.getSelectionModel().getSelectedItem();

        if(selectedTopping == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No toppings selected");
            alert.setContentText("Select a topping to remove it.");
            alert.show();
        } else {
            ObservableList<Topping> list1 = additionalToppingsList.getItems();
            ObservableList<Topping> list2 = selectedToppingsList.getItems();
            list1.add(selectedTopping);
            list2.remove(selectedTopping);

            additionalToppingsList.setItems(list1);
            selectedToppingsList.setItems(list2);
            updatePrice();
        }
    }

    /**
     * Handle what happens when this element is clicked
     * @param event unused event
     */
    @FXML
    void handleAddToOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(selectedToppingsList.getItems().size() < 3) {
            alert.setTitle("Not enough toppings");
            alert.setContentText("You need at least 3 toppings.");
        }
        else if(selectedToppingsList.getItems().size() > 7) {
            alert.setTitle("Too many toppings");
            alert.setContentText("You can have at most 7 toppings.");
        }
        else {
            this.mainMenuController.addToCurrentOrder(getPizza());

            alert.setTitle("Successfully added");
            alert.setContentText("Successfully added pizza to current order.");

            //reinitialize so next pizza can be customized
            initialize();
        }
        alert.show();
    }

    /**
     * Update the price field based on the pizza inputted
     */
    public void updatePrice() {
        double price = getPizza().price();
        priceField.setText(String.format("%.2f", price));
    }

    /**
     * Get the appropriate pizza based on inputted fields
     * @return Pizza object
     */
    public Pizza getPizza() {
        Pizza pizza = PizzaMaker.createPizza("BuildYourOwn");
        pizza.setToppings(new ArrayList<>(selectedToppingsList.getItems()));
        pizza.setSauce(sauceDropdown.getValue());
        pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
        pizza.setExtraSauce(extraSauceCheckbox.isSelected());
        pizza.setSize(sizeDropdown.getValue());
        return pizza;
    }
}