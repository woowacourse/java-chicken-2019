package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private static final List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public int getTableMenuCount() {
        return menus.size();
    }
}
