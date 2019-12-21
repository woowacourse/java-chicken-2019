package domain;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
