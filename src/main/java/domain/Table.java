package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new ArrayList<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isEqualNumber(int inputNumber) {
        return this.number == inputNumber;
    }

    public boolean hasMenu() {
        return menus.size() > 0;
    }

}
