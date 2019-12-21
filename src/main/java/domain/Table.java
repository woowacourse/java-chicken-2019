package domain;

public class Table {
    private final int number;
    private boolean isInUse;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isInUse() {
        return this.isInUse;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
