package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private boolean isTable;
    private final List<Bill> bills = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public void setMenu(String name, int menuNumber, int price) {
        boolean newBill = true;
        for (Bill bill: bills) {
            if (bill.isName(name)) {
                bill.setBill(menuNumber, price);
                newBill = false;
            }
        }
        if (newBill) {
            this.bills.add(new Bill(name, menuNumber, price));
        }
        this.isTable = true;
    }

    public boolean isTable() {
        return this.isTable;
    }

    public void setResetTable() {
        this.isTable = false;
    }

    public List<Bill> getBill() {
        return this.bills;
    }

    public int calculateCashBill() {
        int count = 0;
        for (Bill bill: this.bills) {
            count += bill.getPrice();
        }
        return count;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
