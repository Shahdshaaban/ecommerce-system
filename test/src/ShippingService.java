import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<ShippableProduct> products, Map<Product, Integer> quantities) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");

        for (ShippableProduct shippable : products) {
            Product product = (Product) shippable;
            Integer quantity = quantities.get(product);
            if (quantity == null) {
                quantity = 0;
            }

            double weightKg = shippable.getWeight() * quantity;
            int weightGrams = (int) (weightKg * 1000);

            String line = quantity + "x " + shippable.getName() + " " + weightGrams + "g";
            System.out.println(line);

            totalWeight += weightKg;

        }

        String totalWeightLine = "Total package weight " + String.format("%.1f", totalWeight) + "kg";
        System.out.println(totalWeightLine);
    }
}
