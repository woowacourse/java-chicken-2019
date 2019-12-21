package domain;

public class Order {

    private static final int MINIMUM_CHICKEN = 1;
    private static final int MAXIMUM_CHICKEN = 6;

    final int number;
    final int quantity;

    public Order( int number, int quantity ) {
        this.number = number;
        this.quantity = quantity;
    }

    public boolean isEqual( int menuNumber ) {
        return this.number == menuNumber;
    }

    public boolean isChicken() {
        return (MINIMUM_CHICKEN <= number) && (MAXIMUM_CHICKEN >= number);
    }

    public int getNumber() {
        return number;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return number + ": " + quantity;
    }
}
