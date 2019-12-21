package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
