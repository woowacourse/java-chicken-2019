package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Menu> orders = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
}
