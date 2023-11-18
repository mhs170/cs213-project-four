package pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<Pizza> pizzas;

    public Order() {
        this.orderNumber = StoreOrders.getNextOrderNumber();
        this.pizzas = new ArrayList<Pizza>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void addToOrder(Pizza pizza) {
        this.pizzas.add(pizza);
    }
    public void removeFromOrder(Pizza pizza){
        this.pizzas.remove(pizza);
    }
}
