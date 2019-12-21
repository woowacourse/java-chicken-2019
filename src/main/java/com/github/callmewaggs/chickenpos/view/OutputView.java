package com.github.callmewaggs.chickenpos.view;

import com.github.callmewaggs.chickenpos.domain.Menu;
import com.github.callmewaggs.chickenpos.domain.Order;
import com.github.callmewaggs.chickenpos.domain.Table;
import java.util.List;

public class OutputView {
  private static final String TOP_LINE = "┌ ─ ┐";
  private static final String TABLE_FORMAT = "| %s |";
  private static final String BOTTOM_LINE = "└ ─ ┘";

  public static void printTables(final List<Table> tables) {
    System.out.println("## 테이블 목록");
    final int size = tables.size();
    printLine(TOP_LINE, size);
    printTableNumbers(tables);
    printLine(BOTTOM_LINE, size);
  }

  public static void printMenus(final List<Menu> menus) {
    for (final Menu menu : menus) {
      System.out.println(menu);
    }
  }

  private static void printLine(final String line, final int count) {
    for (int index = 0; index < count; index++) {
      System.out.print(line);
    }
    System.out.println();
  }

  private static void printTableNumbers(final List<Table> tables) {
    for (final Table table : tables) {
      System.out.printf(TABLE_FORMAT, table);
    }
    System.out.println();
  }
  public static void printMessage(String message) {
    System.out.println(message);
    System.out.println();
  }

  public static void printOrders(List<Order> orders) {
    System.out.println("## 주문 내역");
    System.out.println("메뉴 수량 금액");
    for(Order order : orders) {
      System.out.println(order);
    }
  }
}
