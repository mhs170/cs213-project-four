package pizza;

import java.util.ArrayList;

public class Pepperoni extends Pizza {
    private static final Sauce SAUCE = Sauce.TOMATO;
    private static final double SMALL_PRICE = 10.99;

    /**
     * Constructor to create new pepperoni pizza object
     * @param toppings list of toppings
     * @param size pizza size
     * @param sauce pizza sauce
     * @param extraSauce if there's extra sauce
     * @param extraCheese if there's extra cheese
     * @param price final price
     */
    public Pepperoni(ArrayList<Topping> toppings, Size size, Sauce sauce,
                     boolean extraSauce, boolean extraCheese, double price) {
        super(toppings, size, sauce, extraSauce, extraCheese, price);
    }

    /**
     * Method to calculate final price
     * @return final price
     */
    @Override
    public double price() {
        double price = SMALL_PRICE;
        if (size.equals(Size.MEDIUM)){
            price += EXTRA_FOR_MEDIUM;
        }
        if (size.equals(Size.LARGE)){
            price += EXTRA_FOR_LARGE;
        }
        if (extraCheese){
            price += 1;
        }
        if (extraSauce){
            price += 1;
        }
        return price;
    }
    public void addToppings(ArrayList<Topping> toppings){
        toppings.add(Topping.PEPPERONI);
    }
}
