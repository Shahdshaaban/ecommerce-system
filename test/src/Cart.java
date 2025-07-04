import java.util.*;

public class Cart {

    private String itemName;
    private int quantity;

    private Map<Product, Integer> cart = new HashMap<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0 for product: " + product.getName());
        }

        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for product: " + product.getName());
        }

        if (product instanceof ExpirableProduct) {
            if (((ExpirableProduct) product).isExpired()) {
                throw new IllegalArgumentException("Product is expired: " + product.getName());
            }
        }

        int currentQty = cart.getOrDefault(product, 0);
        cart.put(product, currentQty + quantity);
    }


    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public Map<Product, Integer> getItems() {
        return cart;
    }

}
