package pizza;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for build your own
 * @author Mohammed Salama, Dakshal Panicker
 */
public class BuildYourOwnTest {

    @Test
    public void testBaseSmall() {
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.size = Size.SMALL;
        assertEquals(8.99, test.price(), 0);
    }

    @Test
    public void testBaseMedium(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.size = Size.MEDIUM;
        assertEquals(10.99, test.price(), 0);
    }

    @Test
    public void testBaseLarge(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.size = Size.LARGE;
        assertEquals(12.99, test.price(), 0);
    }

    @Test
    public void testThreeToppings(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.toppings.add(Topping.BLACK_OLIVE);
        test.toppings.add(Topping.PEPPERONI);
        test.toppings.add(Topping.PINEAPPLE);
        assertEquals(8.99, test.price(), 0);
    }

    @Test
    public void testFourToppings(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.toppings.add(Topping.BLACK_OLIVE);
        test.toppings.add(Topping.PEPPERONI);
        test.toppings.add(Topping.PINEAPPLE);
        test.toppings.add(Topping.MUSHROOM);
        assertEquals(10.48, test.price(), 0);
    }

    @Test
    public void testMaxToppings(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.toppings.add(Topping.BLACK_OLIVE);
        test.toppings.add(Topping.PEPPERONI);
        test.toppings.add(Topping.PINEAPPLE);
        test.toppings.add(Topping.MUSHROOM);
        test.toppings.add(Topping.GREEN_PEPPER);
        test.toppings.add(Topping.CRAB_MEATS);
        test.toppings.add(Topping.BEEF);
        assertEquals(14.95, test.price(), 0);
    }

    @Test
    public void testExtraCheese(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.extraCheese = true;
        assertEquals(9.99, test.price(), 0);
    }

    @Test
    public void testExtraSauce(){
        Pizza test = PizzaMaker.createPizza("BuildYourOwn");
        test.extraSauce = true;
        assertEquals(9.99, test.price(), 0);
    }
}