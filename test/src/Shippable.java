public class Shippable extends Product implements ShippableProduct {

    private double weight;

    public Shippable(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
