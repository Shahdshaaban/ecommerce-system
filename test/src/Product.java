import java.util.*;
import java.time.LocalDate;

public abstract class Product {

    private String name;
    private double price;
    private int quantity;


    public Product (){
    }
    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public abstract boolean requiresShipping();


}
