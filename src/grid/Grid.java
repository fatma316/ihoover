package grid;

import enums.Order;
import hoover.IHoover;

public class Grid {
    private int height;
    private int width;
    private IHoover hoover;

    public Grid(int height, int width, IHoover hoover) {
        this.height = height;
        this.width = width;
        this.hoover = hoover;
    }

    public void applyOrders(Orders orders) {
        while (!orders.isEmpty()) {
            Order order = orders.getNextOrder();
            switch (order) {
                case ADVANCE:
                    this.hoover.advance();
                    break;
                case LEFT:
                    this.hoover.rotateToLeft();
                    break;
                case RIGHT:
                    this.hoover.rotateToRight();
                    break;
            }
            if (hoover.getCurrentX() > this.width || hoover.getCurrentX() < 0 || hoover.getCurrentY() > this.height || hoover.getCurrentY() < 0) {
                System.out.println("illegal list of moves");
                System.exit(0);
            }
        }
    }

    public void showGameStatus() {
        this.hoover.showCurrentPosition();
    }
}
