package pizza;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class SpecialityController {

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
    private ListView<String> toppingsList;

    @FXML
    private ComboBox<String> sizeDropdown;

    @FXML
    private ComboBox<String> typeDropdown;

    ObservableList<String> types = FXCollections.observableArrayList(
            "Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood"
    );

    ObservableList<String> sizes = FXCollections.observableArrayList(
            "Small", "Medium", "Large"
    );

    Map<String, ObservableList<String>> toppingsMap  = new HashMap<>();

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
                "Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom"
        ));
        toppingsMap.put("Supreme", FXCollections.observableArrayList(
                "Sausage", "Pepperoni", "Ham", "Green Pepper", "Onion", "Black Olive", "Mushroom"
        ));
        toppingsMap.put("Meatzza", FXCollections.observableArrayList(
                "Sausage", "Pepperoni", "Beef", "Ham"
        ));
        toppingsMap.put("Pepperoni", FXCollections.observableArrayList(
                "Pepperoni"
        ));
        toppingsMap.put("Seafood", FXCollections.observableArrayList(
                "Shrimp", "Squid", "Crab Meats"
        ));

        toppingsList.setItems(toppingsMap.get("Deluxe"));

        //sauce

        sauceField.setText("Tomato");
    }

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
            sauceField.setText("Tomato");
        } else {
            sauceField.setText("Alfredo");
        }

    }

    void handleSizeDropdown(ActionEvent event) {

    }

    @FXML
    void handleAddToOrder(ActionEvent event) {

    }
}
