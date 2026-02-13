import java.util.ArrayList;
import java.util.List;

// --- 1. Product Class ---
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("- %-15s: $%.2f", name, price);
    }
}

// --- 2. ShoppingCart Class ---
class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added to cart: " + product.getName());
    }

    public void removeProduct(String productName) {
        // Using an Iterator or removeIf to safely remove while iterating
        boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
        
        if (removed) {
            System.out.println("Removed from cart: " + productName);
        } else {
            System.out.println("Error: " + productName + " not found in cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\n--- Your Shopping Cart ---");
        if (products.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
            System.out.println("---------------------------");
            System.out.printf("Total Cost: $%.2f\n", calculateTotalCost());
        }
    }
}

// --- 3. Main Class ---
public class Main {
    public static void main(String[] args) {
        ShoppingCart myCart = new ShoppingCart();

        // Adding products
        myCart.addProduct(new Product("Laptop", 999.99));
        myCart.addProduct(new Product("Mouse", 25.50));
        myCart.addProduct(new Product("Keyboard", 45.00));

        // Display initial cart
        myCart.displayCart();

        // Removing a product
        System.out.println("\nAction: Removing 'Mouse'...");
        myCart.removeProduct("Mouse");

        // Display final cart and total
        myCart.displayCart();
    }
}