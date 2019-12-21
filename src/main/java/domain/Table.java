package domain;

import java.util.Collections;

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

    public double sum(boolean isCash) {
        if (isCash) {
            return shoppingBasket.sum() * 0.95;
        }
        return shoppingBasket.sum();
    }

    public String orderHistory() {
        return shoppingBasket.toString();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
