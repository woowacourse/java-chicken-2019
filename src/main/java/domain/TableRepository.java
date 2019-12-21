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

    public static void takeOrder(int table, Order order) {
        tables.get(getTableIndex(table)).addOrder(order);
    }

    public static List<Order> getOrders(int tableNumber) {
        return Collections.unmodifiableList(tables.get(getTableIndex(tableNumber)).getOrders());
    }

    public static int getTotalPayment(int tableNumber) {
        return tables.get(getTableIndex(tableNumber)).getTotalPayment();
    }

    public static void deleteAllOrders(int tableNumber) {
        tables.get(getTableIndex(tableNumber)).cleanOrders();
    }

    private static int getTableIndex(int tableNumber) {
        int tableIndex = 0;

        while (!tables.get(tableIndex).isTableNumberSame(tableNumber)) {
            tableIndex++;
        }

        return tableIndex;
    }
}
