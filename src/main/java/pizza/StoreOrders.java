package pizza;

import java.util.ArrayList;
import java.util.List;

public class StoreOrders {
    private static int nextOrderNumber; //automatically initialized to 0
    private List<Order> orders;

    public static int getNextOrderNumber() {
        nextOrderNumber ++;
        return nextOrderNumber;
    }

    public StoreOrders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
