/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 치킨집이 보유한 테이블들에 대한 클래스입니다.
 * @since : 2019.12.23 월요일
 */
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

    public static boolean hasThisNumberOfTable(int inputNumber) {
        List<Integer> tableNumberList = new ArrayList<>();
        for (Table table : tables) {
            tableNumberList.add(table.getNumber());
        }
        return tableNumberList.contains(inputNumber);
    }
}
