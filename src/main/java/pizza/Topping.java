package pizza;

public enum Topping {
    //sausage, pepperoni, green pepper, onion, mushroom, ham, black olive, beef,  shrimp, squid, crab meats
    SAUSAGE ("Sausage"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    HAM("Ham"),
    BLACK_OLIVE("Black Olive"),
    BEEF("Beef"),
    SHRIMP("Shrimp"),
    SQUID("Squid"),
    CRAB_MEATS("Crab Meats");

    private final String topping;

    /**
     * Constructor method to initialize topping object
     * @param topping
     */
    Topping(String topping){
        this.topping = topping;
    }

    /**
     * Getter method to return the topping
     * @return topping
     */
    public String getTopping(){
        return topping;
    }


}
