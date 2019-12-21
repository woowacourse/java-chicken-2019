package domain;

public class Table {
    private final int number;
    private boolean isTable;
    private String name;
    private int menuNumber;
    private int price;

    public Table(final int number) {
        this.number = number;
    }

    public void setMenu(String name, int menuNumber, int price) {
        this.name = name;
        this.menuNumber = menuNumber;
        this.price = price;
        this.isTable = true;
    }

    public boolean isTable() {
        return this.isTable;
    }

    public void setResetTable() {
        this.isTable = false;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
