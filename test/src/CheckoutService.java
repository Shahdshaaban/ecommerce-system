import java.util.*;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty!");
        }

        double subtotal = 0;
        double shippingFee = 0;
        List<ShippableProduct> itemsToShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof ExpirableProduct) {
                ExpirableProduct exp = (ExpirableProduct) product;
                if (exp.isExpired()) {
                    throw new IllegalStateException("Product expired: " + product.getName());
                }
            }

            if (quantity > product.getQuantity()) {
                throw new IllegalStateException("Out of stock: " + product.getName());
            }

            subtotal += product.getPrice() * quantity;

            if (product instanceof ShippableProduct) {
                itemsToShip.add((ShippableProduct) product);
            }
        }

        if (!itemsToShip.isEmpty()) {
            shippingFee = 30;
            ShippingService.ship(itemsToShip, cart.getItems());
        }

        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Customer has insufficient balance.");
        }

        customer.deductBalance(total);

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double totalPrice = product.getPrice() * quantity;
            String line = quantity + " x " + product.getName() +" " + ((int)totalPrice);
            System.out.println(line);
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shippingFee);
        System.out.println("Amount " + (int)total);
    }
}
