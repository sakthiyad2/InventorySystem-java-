import java.util.*;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("ID: " + id + " Name: " + name +
                " Price: " + price + " Quantity: " + quantity);
    }
}

class Inventory {
    HashMap<Integer, Product> stock = new HashMap<>();

    void addProduct(Product p) {
        stock.put(p.id, p);
        System.out.println("Product added successfully.");
    }

    void viewProducts() {
        if (stock.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product p : stock.values()) {
            p.display();
        }
    }

    void updateQuantity(int id, int qty) {
        if (stock.containsKey(id)) {
            stock.get(id).quantity = qty;
            System.out.println("Quantity updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void removeProduct(int id) {
        if (stock.remove(id) != null) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }
}

public class InventorySystem {

    public static void main(String[] args) {

        Scanner S = new Scanner(System.in);
        Inventory inv = new Inventory();

        while (true) {

            System.out.println("\n1.Add Product");
            System.out.println("2.View Products");
            System.out.println("3.Update Quantity");
            System.out.println("4.Remove Product");
            System.out.println("5.Exit");

            System.out.print("Enter choice: ");
            int choice = S.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = S.nextInt();

                    System.out.print("Enter Name: ");
                    String name = S.next();

                    System.out.print("Enter Price: ");
                    double price = S.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = S.nextInt();

                    Product p = new Product(id, name, price, qty);
                    inv.addProduct(p);
                    break;

                case 2:
                    inv.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int uid = S.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = S.nextInt();

                    inv.updateQuantity(uid, newQty);
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int rid = S.nextInt();
                    inv.removeProduct(rid);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    S.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
           
        }
    }
}