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

    public Boolean isItInt(Integer input) {
        if (this.number == input) {
            return true;
        }
        return false;
    }
}
