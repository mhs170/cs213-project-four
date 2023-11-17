package pizza;

import java.util.ArrayList;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        switch (pizzaType) {
            case "Deluxe":
                pizza = new Deluxe(Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Supreme":
                pizza = new Supreme(Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Meatzza":
                pizza = new Meatzza(Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Pepperoni":
                pizza = new Pepperoni(Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Seafood":
                pizza = new Seafood(Size.SMALL, Sauce.ALFREDO,
                        false, false, 0);
            case "BuildYourOwn":
                pizza = new BuildYourOwn(null, Size.SMALL, Sauce.TOMATO
                        , false, false, 0);
        }
        return pizza;
    }
}