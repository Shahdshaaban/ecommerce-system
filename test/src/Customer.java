public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() { return name; }

    public double getBalance() { return balance; }

    public void deductBalance(double quantity) {
        if (quantity > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= quantity;
    }
}
