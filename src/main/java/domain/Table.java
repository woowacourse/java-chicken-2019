package domain;

public class Table {
    private final int number;
    private Bill bill;

    public Table(final int number) {
        this.number = number;
        bill = new Bill();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Integer) {
            Integer number = (Integer) o;
            return this.number == number;
        }
        return false;
    }

    public void addOrder(Order order) {
        bill.updateBill(order);
    }
}
