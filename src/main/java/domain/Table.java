package domain;

public class Table {
    private final int number;
    private Ordered ordered = new Ordered();

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(Menu menu, int amount) {
        ordered.addMenu(menu, amount);
    }

    public boolean isTableNumberSame(int number) {
        return this.number == number;
    }

    public int allPrices() {
        return ordered.allPrices();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
