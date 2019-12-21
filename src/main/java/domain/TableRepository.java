/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
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

    public static boolean hasThisNumberOfTable(int inputNumber) { // TODO refactor needed.
        List<Integer> tableNumberList = new ArrayList<>();
        for (Table table : tables) {
            tableNumberList.add(table.getNumber());
        }
        return tableNumberList.contains(inputNumber);
    }
}
