package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> orderMenu = new ArrayList<>();
    private int money = 0;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
