package domain;

public class Table {
    private final int number;
    private Menu menu;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isThisNumber(int number) {
        return this.number == number;
    }

    public boolean haveMenu() {
        return this.menu != null;
    }
}
