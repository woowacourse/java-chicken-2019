package domain;

import java.util.HashMap;
import java.util.List;

public class Table {
    private final int number;
    private boolean guestPresence;
    private HashMap<Integer, Integer> tableMenu;
    private static final List<Menu> menus = MenuRepository.menus();


    public Table(final int number) {
        this.number = number;
        this.guestPresence = false;
        this.tableMenu = new HashMap<>();
    }

    public void addMenu(int menuNumber, int menuAmount) {
        guestPresence = true;
        if (tableMenu.containsKey(menuNumber)) {
            tableMenu.put(menuNumber, tableMenu.get(menuNumber) + menuAmount);
        }
        if (!tableMenu.containsKey(menuNumber)) {
            tableMenu.put(menuNumber, menuAmount);
        }
    }

    public boolean hasGuest() {
        return this.guestPresence;
    }

    public String toStringBill() {
        String bill = "";
        for (int index = 0; index < menus.size(); index ++) {
            if (tableMenu.containsKey(index)) {
                bill += menus.get(index).toString() + "\n";
            }
        }
        return bill;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
