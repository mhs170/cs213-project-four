package pizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Meatzza pizza type
 * @author Mohammed Salama, Dakshal Panicker
 */
public class Meatzza extends Pizza {
    private static final Sauce SAUCE = Sauce.TOMATO;
    private static final double SMALL_PRICE = 16.99;

    /**
     * Constructor method to create new meatzza object
     *
     * @param size        pizza size
     * @param sauce       pizza sauce
     * @param extraSauce  if there's extra sauce
     * @param extraCheese if there's extra cheese
     * @param price       final price
     */
    public Meatzza(Size size, Sauce sauce,
                   boolean extraSauce, boolean extraCheese, double price) {
        super(new ArrayList<>(
                Arrays.asList(
                        Topping.SAUSAGE,
                        Topping.PEPPERONI,
                        Topping.BEEF,
                        Topping.HAM
                )
        ), size, sauce, extraSauce, extraCheese, price);
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
}
