package pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<Pizza> pizzas;

    private static final double SALES_TAX_PERCENTAGE = 0.06625;

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

    public double getSubtotal(){
        double subtotal = 0;
        for (Pizza pizza : pizzas) {
            subtotal += pizza.price();
        }
        return subtotal;
    }

    public double getSalesTax(){
        return SALES_TAX_PERCENTAGE * getSubtotal();
    }

    public double getTotal(){
        return getSalesTax() + getSubtotal();
    }
}
