package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private Bill bill;

    public Table(final int number) {
        this.number = number;
        this.bill = new Bill();
    }

    public boolean isThisTable(int tableNumber) {
        return this.number == tableNumber;
    }

    public void addOrder(Order order) {
        this.bill.addOrder(order);
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
