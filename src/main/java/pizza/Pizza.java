package pizza;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class

    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;
    public abstract double price(); //polymorphism
    protected static final double EXTRA_FOR_MEDIUM = 2.00;
    protected static final double EXTRA_FOR_LARGE = 4.00;

    public Pizza(ArrayList<Topping> toppings, Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, double price) {
        this.toppings = toppings;
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
        this.price();
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public void setExtraCheese(boolean extraCheese){
        this.extraCheese = extraCheese;
    }

    public void setExtraSauce(boolean extraSauce){
        this.extraSauce = extraSauce;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public void setSauce(Sauce sauce){
        this.sauce = sauce;
    }
}