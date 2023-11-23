package pizza;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * Controller for speciality pizza view
 * @author Mohammed Salama, Dakshal Panicker
 */
public class SpecialityController {

    private MainMenuController mainMenuController;

    @FXML
    private Button addToOrderButton;

    @FXML
    private CheckBox extraCheeseCheckbox;

    @FXML
    private CheckBox extraSauceCheckbox;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField priceField;

    @FXML
    private TextField sauceField;

    @FXML
    private ListView<Topping> toppingsList;

    @FXML
    private ComboBox<Size> sizeDropdown;

    @FXML
    private ComboBox<String> typeDropdown;

    ObservableList<String> types = FXCollections.observableArrayList(
            "Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood"
    );

    ObservableList<Size> sizes = FXCollections.observableArrayList(
            Size.SMALL, Size.MEDIUM, Size.LARGE
    );

    Map<String, ObservableList<Topping>> toppingsMap  = new HashMap<>();

    /**
     * Set the main controller as a private variable to access its properties
     * @param controller main controller
     */
    void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

    /**
     * Initialize the fields of the form (runs automatically)
     */
    @FXML
    void initialize() {

        //initialize type dropdown

        typeDropdown.setItems(types);
        typeDropdown.getSelectionModel().selectFirst(); //default
        typeDropdown.setOnAction(this::handleTypeDropdown);

        //initialize size dropdown

        sizeDropdown.setItems(sizes);
        sizeDropdown.getSelectionModel().selectFirst();
        sizeDropdown.setOnAction(this::handleSizeDropdown);

        //init toppings list

        toppingsMap.put("Deluxe", FXCollections.observableArrayList(
                Topping.SAUSAGE,
                Topping.PEPPERONI,
                Topping.GREEN_PEPPER,
                Topping.BLACK_OLIVE,
                Topping.MUSHROOM
        ));
        toppingsMap.put("Supreme", FXCollections.observableArrayList(
                Topping.SAUSAGE,
                Topping.PEPPERONI,
                Topping.HAM,
                Topping.GREEN_PEPPER,
                Topping.ONION,
                Topping.BLACK_OLIVE,
                Topping.MUSHROOM
        ));
        toppingsMap.put("Meatzza", FXCollections.observableArrayList(
                Topping.SAUSAGE,
                Topping.PEPPERONI,
                Topping.BEEF,
                Topping.HAM
        ));
        toppingsMap.put("Pepperoni", FXCollections.observableArrayList(
                Topping.PEPPERONI
        ));
        toppingsMap.put("Seafood", FXCollections.observableArrayList(
                Topping.SHRIMP,
                Topping.SQUID,
                Topping.CRAB_MEATS
        ));

        toppingsList.setItems(toppingsMap.get("Deluxe"));

        //sauce

        sauceField.setText(Sauce.TOMATO.getSauce());

        //set default price

        updatePrice();
    }

    /**
     * Handle the type dropdown
     * @param event usnused event
     */
    @FXML
    void handleTypeDropdown(ActionEvent event) {

        String type = typeDropdown.getValue();

        //image change

        String path = String.format("src/main/resources/pizza/images/pizza_types/%s.jpg", type);
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);

        //toppings change

        toppingsList.setItems(toppingsMap.get(type));

        //sauce change

        if(type.equals("Seafood")){
            sauceField.setText(Sauce.ALFREDO.getSauce());
        } else {
            sauceField.setText(Sauce.TOMATO.getSauce());
        }

        //update price field

        updatePrice();
    }

    /**
     * Update price when the corresponding element changes
     */
    @FXML
    void handleCheckedExtraCheese() {
        updatePrice();
    }

    /**
     * Update price when the corresponding element changes
     */
    @FXML
    void handleCheckedExtraSauce() {
        updatePrice();
    }

    /**
     * Update price when the corresponding element changes
     */
    @FXML
    void handleSizeDropdown(ActionEvent event) {
        updatePrice();
    }

    /**
     * Handle add to order button and show popup
     * @param event
     */
    @FXML
    void handleAddToOrder(ActionEvent event) {
        mainMenuController.addToCurrentOrder(getPizza());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully added");
        alert.setContentText("Pizza was successfully added to the order");
        alert.show();
    }

    /**
     * Update price field based on calculated pizza
     */
    public void updatePrice() {
        double price = getPizza().price();
        priceField.setText(String.format("%.2f", price));
    }

    /**
     * Generate the pizza object that corresponds to the user input
     * @return Pizza object
     */
    public Pizza getPizza() {
        Pizza pizza = PizzaMaker.createPizza(typeDropdown.getValue());
        pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
        pizza.setExtraSauce(extraSauceCheckbox.isSelected());
        pizza.setSize(sizeDropdown.getValue());
        return pizza;
    }
}
