package grid;

import enums.Order;

import java.util.ArrayList;

public class Orders {
    ArrayList<Order> orders;

    public Orders() {
        this.orders = new ArrayList<Order>();
    }

    public Order getNextOrder() {
        return orders.remove(0);
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
