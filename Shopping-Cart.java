import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class ShoppingCart {
    private List<Product> cart = new ArrayList<>();

    public void addProduct(Product p) {
        cart.add(p);
        System.out.println("Added: " + p.getName());
    }

    public void showTotal() {
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        System.out.println("Total amount: ₹" + total);
    }
}
public class ShopApp {
    public static void main(String[] args) {
        Product p1 = new Product("T-shirt", 499);
        Product p2 = new Product("Shoes", 1999);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.showTotal(); 
    }
}
