package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public void order(int tableNumber, Menu menu, int amount) {
        if (tables.get(tableNumber).order().containsKey(menu))
            amount += tables.get(tableNumber).order().get(menu);
        tables.get(tableNumber).order().put(menu, amount);
    }
}
