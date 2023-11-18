package pizza;

import java.util.ArrayList;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        return switch (pizzaType) {
            case "Deluxe" -> new Deluxe(Size.SMALL, Sauce.TOMATO,
                    false, false, 0);
            case "Supreme" -> new Supreme(Size.SMALL, Sauce.TOMATO,
                    false, false, 0);
            case "Meatzza" -> new Meatzza(Size.SMALL, Sauce.TOMATO,
                    false, false, 0);
            case "Pepperoni" -> new Pepperoni(Size.SMALL, Sauce.TOMATO,
                    false, false, 0);
            case "Seafood" -> new Seafood(Size.SMALL, Sauce.ALFREDO,
                    false, false, 0);
            case "BuildYourOwn" ->
                    new BuildYourOwn(null, Size.SMALL, Sauce.TOMATO
                            , false, false, 0);
            default ->
                    throw new IllegalStateException("Unexpected value: " + pizzaType);
        };
    }
}