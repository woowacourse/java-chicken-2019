package domain;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
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
}
