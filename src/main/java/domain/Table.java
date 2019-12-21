package domain;

import java.util.HashMap;

public class Table {
    private final int number;
    private boolean guestPresence;
    private HashMap<Integer, Integer> tableMenu;
    private boolean guest;

    public Table(final int number) {
        this.number = number;
        this.guestPresence = false;
        this.tableMenu = new HashMap<>();
        this.guest = false;
    }

    public void addMenu(int menuNumber, int menuAmount) {
        guest = true;
        if (!tableMenu.containsKey(menuNumber)) {
            tableMenu.put(menuNumber, menuAmount);
        }
        if (tableMenu.containsKey(menuNumber)) {
            tableMenu.put(menuNumber, tableMenu.get(menuNumber) + menuAmount);
        }
    }

    public boolean hasGuest() {
        return this.guest;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
