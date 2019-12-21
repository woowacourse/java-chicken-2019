package domain;

public class Table {
    private final int number;
    private final ShoppingBasket shoppingBasket;

    public Table(final int number) {
        this.number = number;
        shoppingBasket = new ShoppingBasket();
    }

    public boolean isEmpty() {
        return shoppingBasket.isEmpty();
    }

    public void clear() {
        shoppingBasket.clear();
    }

    public void offer(Order order) {
        shoppingBasket.offer(order);
    }

    public int sum() {
        return shoppingBasket.sum();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
