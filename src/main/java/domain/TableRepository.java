/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * TableRepository.java
 * 테이블 데이터를 조회하는 DB역할을 하는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
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

    public static boolean hasTableNumber(String inputTableNumber) {
        for (Table table : tables()) {
            if (table.toString().equals(inputTableNumber)) {
                return true;
            }
        }
        return false;
    }

    public static Table getTableByNumber(int number) {

        for (Table table : tables()) {
            if (table.toString().equals(Integer.toString(number))) {
                return table;
            }
        }
        return null;
    }


}
