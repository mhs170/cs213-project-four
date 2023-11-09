package pizza;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");
    private final String size;

    /**
     * Constructor method to initialize size object
     * @param size
     */
    Size(String size){
        this.size = size;
    }

    /**
     * Getter method to return size of pizza
     * @return pizza size
     */
    public String getSize(){
        return size;
    }
}
