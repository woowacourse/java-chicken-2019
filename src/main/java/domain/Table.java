package domain;

import java.util.HashMap;

public class Table {
    private final int number;
    private boolean guestPresence;
    private HashMap<Integer, Integer> tableMenu;

    private final int ONE = 1;

    public Table(final int number) {
        this.number = number;
        this.guestPresence = false;
        this.tableMenu = new HashMap<>();
    }

    public void addMenu(int menuNumber, int menuAmount) {
        if (!tableMenu.containsKey(menuNumber)) {
            tableMenu.put(menuNumber, menuAmount);
        }
        if (tableMenu.containsKey(menuNumber)) {
            tableMenu.put(menuNumber, tableMenu.get(menuNumber) + menuAmount);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
