import java.util.Date;

public class Expirable extends Shippable implements ExpirableProduct{
    private Date expiryDate;

    public Expirable(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
}
