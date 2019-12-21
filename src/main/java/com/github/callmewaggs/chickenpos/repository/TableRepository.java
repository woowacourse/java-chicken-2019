package com.github.callmewaggs.chickenpos.repository;

import com.github.callmewaggs.chickenpos.domain.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
  private static final List<Table> tables = new ArrayList<>();

  static {
    tables.add(new Table(1, true));
    tables.add(new Table(2, true));
    tables.add(new Table(3, true));
    tables.add(new Table(5, true));
    tables.add(new Table(6, true));
    tables.add(new Table(8, true));
  }

  public static List<Table> tables() {
    return Collections.unmodifiableList(tables);
  }

  public static void markTable(int tableNumber) {
    for (Table table : tables) {
      if(table.isNumber(tableNumber)) {
        table.setAvailable(false);
      }
    }
  }
}
