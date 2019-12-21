package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addMenus(Menu menu) {
        menus.add(menu);
    }

    public boolean isOrdered() {
        return menus.isEmpty();
    }

    public boolean isSame(int number) {
        return this.number == number;
    }

}
