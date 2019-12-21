package domain;

public class Table {
    private final int number;
    private Menus menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new Menus();
    }
    
    public boolean isTheTable(int number) {
        return this.number == number;
    }
    
    public void addMenu(int menuNumber, int count) {
        menus.addMenuByNumber(menuNumber, count);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
