import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expiredDate = sdf.parse("2026-12-31");

        Product cheese = new Expirable("Cheese", 100, 10, 0.2, expiredDate);
        Product biscuits = new Expirable("Biscuits", 150, 10, 0.7, expiredDate);
        Product tv = new Shippable("TV", 1300, 5, 5.0);
        Product scratchCard = new Product("ScratchCard", 50, 20) {
            @Override
            public boolean requiresShipping() {
                return false;
            }
        };

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        cart.add(tv, 2);

        Customer customer = new Customer("Shahd", 5000);

        CheckoutService.checkout(customer, cart);
    }
}
