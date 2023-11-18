package pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

    public List<Integer> getOrderNumbers() {
        List<Integer> orderNumbers = new ArrayList<>();
        for(Order order : orders) {
            orderNumbers.add(order.getOrderNumber());
        }
        return orderNumbers;
    }

    public Order getOrder(int orderNumber) {
        for(Order order: orders) {
            if(order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }
}
