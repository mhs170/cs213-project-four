package pizza;

import java.util.ArrayList;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        ArrayList<Topping> toppings = null;
        switch (pizzaType) {
            case "Deluxe":
                pizza = new Deluxe(toppings, Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Supreme":
                pizza = new Supreme(toppings, Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Meatzza":
                pizza = new Meatzza(toppings, Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Pepperoni":
                pizza = new Pepperoni(toppings, Size.SMALL, Sauce.TOMATO,
                        false, false, 0);
            case "Seafood":
                pizza = new Seafood(toppings, Size.SMALL, Sauce.ALFREDO,
                        false, false, 0);
            case "BuildYourOwn":
                pizza = new BuildYourOwn(toppings, Size.SMALL, Sauce.TOMATO
                        , false, false, 0);
        }
        return pizza;
    }
}