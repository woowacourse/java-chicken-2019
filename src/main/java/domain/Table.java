package domain;

public class Table {
    private final int number;
    private int totalMenuQuantity;

    public Table(final int number) {
        this.number = number;
    }

    public boolean existTableNumber(int tableNumber) {
        if (tableNumber == (int) this.number) {
            return true;
        }

        return false;
    }

    public boolean isOrder() {
        if (OrderList.search(this.number).isEmpty()) {
            return false;
        }

        return true;


    }


    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
