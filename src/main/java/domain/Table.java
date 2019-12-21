package domain;

public class Table  extends StoreTool{
    private final Bills bills = new Bills();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrder(Menu menu, int quantity) {
        bills.add(menu, quantity);
    }

    public int calculateAmount() {
        return bills.calculateAmount();
    }

    public boolean isNoOrder() {
        return bills.isEmpty();
    }

    public Bills getBills() {
        return bills;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
