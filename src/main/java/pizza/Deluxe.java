package pizza;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    private final Sauce SAUCE = Sauce.TOMATO;
    private Size size;
    private final double SMALL_PRICE = 14.99;
    private final double EXTRA_FOR_MEDIUM = 2.00;
    private final double EXTRA_FOR_LARGE = 4.00;

    /**
     * Constructor method to create new deluxe pizza object
     * @param toppings pizza toppings
     * @param size pizza size
     * @param sauce pizza sauce
     * @param extraSauce if there's extra sauce
     * @param extraCheese if there's extra cheese
     * @param price final price
     */
    public Deluxe(ArrayList<Topping> toppings, Size size, Sauce sauce,
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
        if(size.equals(Size.MEDIUM)){
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
}
