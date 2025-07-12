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
        
    }
}