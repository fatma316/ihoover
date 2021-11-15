import grid.Grid;
import grid.Orders;
import hoover.HooverFactory;
import hoover.IHoover;
import utils.HooverUtils;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simulation {
    Scanner scanner = new Scanner(System.in);
    HooverFactory hooverFactory = new HooverFactory();

    /**
     * This method create a simulation with inputs provided by the user
     */
    public void startSimulationWithUserInput() {
        int height = askForGridHeigth();
        int width = askForGridWidth();
        IHoover hoover = askForHooverPosition(height, width);
        Grid grid = new Grid(height, width, hoover);
        Orders orders = askForUserOrders();
        grid.applyOrders(orders);
        grid.showGameStatus();

    }


    /**
     * This method create a simulation for test
     * passing params instead of getting them from user inputs
     *
     * @param height           Longuer de la grille
     * @param width            Largeur de la grille
     * @param x                Position initiale de l'aspirateur de l'axe X
     * @param y                Position initiale de l'aspirateur de l'axe Y
     * @param initialDirection Direction initiale de l'aspirateur
     * @param ordersString     Chaine de caractere contenant les ordres
     */

    public void startSimulationWithPlainInput(int height, int width, int x, int y, String initialDirection, String ordersString) {
        if (height >= 0 && width >= 0 && isValidDirection(initialDirection) && isValidOrderString(ordersString)) {
            IHoover hoover = hooverFactory.createHoover(x, y, initialDirection);
            Grid grid = new Grid(height, width, hoover);
            Orders orders = new Orders();
            HooverUtils.generateOrders(orders, ordersString);
            grid.applyOrders(orders);
            grid.showGameStatus();
        }
    }

    public int askForGridHeigth() {
        while (true) {
            System.out.println("Longueur de la grille:");
            System.out.println("Y=");
            int y = scanner.nextInt();
            if (y >= 0) {
                return y;
            }
        }
    }

    public int askForGridWidth() {
        while (true) {
            System.out.println("Largeur de la grille:");
            System.out.println("X=");
            int x = scanner.nextInt();
            if (x >= 0) {
                return x;
            }
        }
    }

    public IHoover askForHooverPosition(int maxHeight, int maxWidth) {
        System.out.println("Position initiale de l’aspirateur:");
        int x;
        int y;
        String direction;
        do {
            System.out.println("X=");
            x = scanner.nextInt();
        } while (x < 0 || x > maxWidth);
        do {
            System.out.println("Y=");
            y = scanner.nextInt();
        } while (y < 0 || y > maxHeight);
        //scanner.next();
        scanner.nextLine();
        do {
            System.out.println("Direction=");
            direction = scanner.nextLine();
        } while (!isValidDirection(direction));

        return hooverFactory.createHoover(x, y, direction);
    }

    public Orders askForUserOrders() {
        String ordersString;
        do {
            System.out.println("orders:");
            ordersString = scanner.nextLine().toUpperCase().trim();
        } while (!isValidOrderString(ordersString));
        Orders orders = new Orders();
        HooverUtils.generateOrders(orders, ordersString);
        return orders;
    }

    public boolean isValidOrderString(String orders) {
        Pattern orderPattern;
        Matcher matcher;
        orderPattern = Pattern.compile("^[AGD]*$");
        matcher = orderPattern.matcher(orders);
        return matcher.find();
    }

    public boolean isValidDirection(String direction) {
        Pattern directionPattern;
        Matcher matcher;
        directionPattern = Pattern.compile("^[NSWE]{1}$");
        matcher = directionPattern.matcher(direction);
        return matcher.find();
    }


}
