package domain;

import java.util.*;
import java.util.stream.Collectors;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static List<Integer> orderCheck = new ArrayList<>();

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

    public static void setOrderCheck(int value) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getNumber() == value) {
                orderCheck.add(i);
            }
        }
        orderCheck.stream().sorted();
    }

    public static List<Integer> getOrderCheck() {
        return orderCheck;
    }
}
