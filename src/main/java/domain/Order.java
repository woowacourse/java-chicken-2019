package domain;

public class Order {

    final int number;
    final int quantity;

    public Order(int number, int quantity) {
        this.number = number;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return number + " : " + quantity;
    }
}
