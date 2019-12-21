package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Menu> orderedMenuList = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public void getOrderedMenu(Menu orderedMenu) {
        orderedMenuList.add(orderedMenu);
    }

    public boolean isUnpaidTable() {
        return orderedMenuList.size() != 0;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
