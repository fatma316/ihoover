package utils;

import enums.Direction;
import enums.Order;
import grid.Orders;

import java.util.Locale;

public class HooverUtils {
    public static Direction generateDirection(String direction) {

        switch (direction.toUpperCase().trim()) {
            case "N":
                return Direction.NORTH;
            case "E":
                return Direction.EAST;
            case "S":
                return Direction.SOUTH;
            case "W":
                return Direction.WEST;
            default:
                return null;//TODO manage illegal direction
        }
    }

    public static void generateOrders(Orders orders, String ordersString) {
        for (int i = 0; i < ordersString.length(); i++) {
            char order = ordersString.charAt(i);
            switch (order) {
                case 'D':
                    orders.addOrder(Order.RIGHT);
                    break;
                case 'G':
                    orders.addOrder(Order.LEFT);
                    break;
                case 'A':
                    orders.addOrder(Order.ADVANCE);
                    break;
            }
        }
        //return orders;
    }
}
