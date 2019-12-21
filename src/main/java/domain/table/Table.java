package domain.table;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isRightTableNumber(int tableNumer) {
        return number == tableNumer;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
