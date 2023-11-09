package pizza;

import java.util.ArrayList;

public class Pepperoni extends Pizza {

    //auto constructor
    public Pepperoni(ArrayList<Topping> toppings, Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, double price) {
        super(toppings, size, sauce, extraSauce, extraCheese, price);
    }

    @Override
    public double price() {
        return 0;
    }
}
