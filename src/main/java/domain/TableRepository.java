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

    public static void orderToTable(int tableNumber, Menu menu, int amount) {
        findTable(tableNumber)
                .addOrder(menu, amount);
    }

    public static String printMenus(int tableNumber) {
        return findTable(tableNumber).orderToString();
    }

    public static Price checkOutTable(int tableNumber) {
        return findTable(tableNumber)
                .calculatePrice();
    }

    public static void clearTable(int tableNumber) {
        findTable(tableNumber).clearTable();
    }

    private static Table findTable(int tableNumber) {
        return tables.stream()
                .filter(x -> x.isCorrectTable(tableNumber))
                .findFirst()
                .get();
    }
}
