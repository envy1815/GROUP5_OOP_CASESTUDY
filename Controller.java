
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner;
    private final Option shoppingCart;
    private Order menu;

    public Controller(Scanner scanner, Option shoppingCart) {
        this.scanner = scanner;
        this.shoppingCart = shoppingCart;
    }

    public void run() {
        welcomeMessage();
        selectOrderType();

        while (true) {
            int choice = getUserChoice();
            handleUserChoice(choice);
        }
    }

    private void welcomeMessage() {
        System.out.println("Welcome to CyberGrab Ordering System!");
    }

    private void selectOrderType() {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Choose order type: [1] Food [2] Flower [3] Grocery [4] Laundry");
                System.out.print("Enter order type: ");
                int ordertype = scanner.nextInt();
                switch (ordertype) {
                    case 1 -> {
                        menu = new Food();
                        valid = true;
                    }
                    case 2 -> {
                        menu = new Flower();
                        valid = true;
                    }
                    case 3 -> {
                        menu = new Grocery();
                        valid = true;
                    }
                    case 4 -> {
                        menu = new Laundry();
                        valid = true;
                    }
                    default ->
                        System.out.println("Invalid Input! Please enter within the range!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please enter a number!");
                scanner.nextLine();
            }
        }
        System.out.println("Order Type: " + menu.getClass().getSimpleName());
    }

    private int getUserChoice() {
        int choice = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("\n\tSelect an option:");
                System.out.println("[1] Add item to cart [pops menu]");
                System.out.println("[2] Remove item from cart");
                System.out.println("[3] Update item quantity");
                System.out.println("[4] Create a new cart");
                System.out.println("[5] Checkout");
                System.out.println("[6] Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                valid = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1 ->
                shoppingCart.itemAdder(menu);
            case 2 ->
                shoppingCart.itemRemover();
            case 3 ->
                shoppingCart.itemUpdater();
            case 4 ->
                shoppingCart.createNewCart();
            case 5 ->
                shoppingCart.checkout();
            case 6 -> {
                System.out.println("Exiting");
                System.exit(0);
            }
            default ->
                System.out.println("Invalid option. Please try again.");
        }
    }
}
