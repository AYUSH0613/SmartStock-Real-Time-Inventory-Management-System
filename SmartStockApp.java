package SmartStock;
import java.util.*;

class Product {
    String name;
    int quantity;

    Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

enum ActionType {
    ADD, UPDATE, DELETE
}

class Action {
    ActionType type;
    String productId;
    Product previousState;

    Action(ActionType type, String productId, Product previousState) {
        this.type = type;
        this.productId = productId;
        this.previousState = previousState;
    }
}

public class SmartStockApp{
    static Scanner scan=new Scanner(System.in);
    static HashMap<String, Product> inventory = new HashMap<>();
    static Stack<Action> actionHistory = new Stack<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scan.nextLine().trim();
            switch (choice) {
                case "1": addProduct(); break;
                case "2": updateProduct(); break;
                case "3": deleteProduct(); break;
                case "4": viewInventory(); break;
                case "5": undoLastAction(); break;
                case "0": System.out.println("Exiting SmartStock..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }
    static void showMenu() {
        System.out.println("\n📦 SmartStock - Inventory Management");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. View Inventory");
        System.out.println("5. Undo Last Action");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    static void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scan.nextLine();
        if (inventory.containsKey(id)) {
            System.out.println("Product already exists.");
            return;
        }
        System.out.print("Enter product name: ");
        String name = scan.nextLine();
        int quantity = inputQuantity();
        if (quantity < 0) return;

        inventory.put(id, new Product(name, quantity));
        actionHistory.push(new Action(ActionType.ADD, id, null));
        System.out.println("Product added.");
    }

    static void updateProduct() {
        System.out.print("Enter product ID: ");
        String id = scan.nextLine();
        Product existing = inventory.get(id);
        if (existing == null) {
            System.out.println("Product not found.");
            return;
        }
        System.out.print("Enter new quantity: ");
        int quantity = inputQuantity();
        if (quantity < 0) return;

        Product oldCopy = new Product(existing.name, existing.quantity);
        existing.quantity = quantity;
        actionHistory.push(new Action(ActionType.UPDATE, id, oldCopy));
        System.out.println("Product updated.");
    }

    static void deleteProduct() {
        System.out.print("Enter product ID: ");
        String id = scan.nextLine();
        Product removed = inventory.remove(id);
        if (removed == null) {
            System.out.println("Product not found.");
            return;
        }
        actionHistory.push(new Action(ActionType.DELETE, id, removed));
        System.out.println("Product deleted.");
    }

    static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            System.out.printf("ID: %s | Name: %s | Quantity: %d%n",
                    entry.getKey(), entry.getValue().name, entry.getValue().quantity);
        }
    }

    static void undoLastAction() {
        if (actionHistory.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Action last = actionHistory.pop();
        switch (last.type) {
            case ADD:
                inventory.remove(last.productId);
                System.out.println("Undo: Added product removed.");
                break;
            case UPDATE:
                inventory.put(last.productId, last.previousState);
                System.out.println("Undo: Product reverted to previous quantity.");
                break;
            case DELETE:
                inventory.put(last.productId, last.previousState);
                System.out.println("Undo: Deleted product restored.");
                break;
        }
    }

    static int inputQuantity() {
        try {
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scan.nextLine());
            if (qty < 0) {
                System.out.println("Quantity cannot be negative.");
                return -1;
            }
            return qty;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}

