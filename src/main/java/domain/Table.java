package domain;

import java.util.*;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> bills = new HashMap<Menu, Integer>();

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(int menuNumber, int count) {
        Menu menu = MenuRepository.selectMenu(menuNumber);

        bills.put(menu, count);
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
