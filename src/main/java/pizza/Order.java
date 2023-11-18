package pizza;
import java.util.ArrayList;
public class Order {
    ArrayList<Pizza> pizzaArray  = new ArrayList<>();
    private int orderNumber;
    private static int FIRST_ORDER_NUMBER = 1;
    public Order(){
        this.orderNumber = FIRST_ORDER_NUMBER++;
        this.pizzaArray = new ArrayList<>();
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void addPizza(Pizza pizza){
        pizzaArray.add(pizza);
    }
    public void removePizza(Pizza pizza){
        pizzaArray.remove(pizza);
    }
}
