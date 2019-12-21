package domain;

import domain.reserved.OrderedMenus;

public class Table {
    private final OrderedMenus orderedMenus = new OrderedMenus();
    private final int number;

    Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isMatch(int number) {
        return this.number == number;
    }

    public OrderedMenus getOrderedMenus() {
        return orderedMenus;
    }

    public void addMenu(Menu menu, int capacity) {
        orderedMenus.addMenu(menu, capacity);
    }

    public boolean isExistMenu() {
        return orderedMenus.isExistMenu();
    }
}
