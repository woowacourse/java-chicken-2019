package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return tables;
    }

    public static List<Integer> tableValues() {
        return tables.stream()
                .map(Table::tableNumber)
                .collect(Collectors.toList());
    }

}
