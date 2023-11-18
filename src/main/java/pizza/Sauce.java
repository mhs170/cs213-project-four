package pizza;

public enum Sauce {
    TOMATO ("Tomato"),
    ALFREDO ("Alfredo");
    private final String sauce;

    /**
     * Constructor method that initializes the Sauce object
     * @param sauce type of sauce
     */
    Sauce(String sauce){
        this.sauce = sauce;
    }

    /**
     * Getter method to return the type of sauce
     * @return sauce
     */
    public String getSauce(){
        return sauce;
    }
    @Override
    public String toString() {
        return sauce;
    }
}
