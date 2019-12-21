package com.github.callmewaggs.chickenpos.view;

import com.github.callmewaggs.chickenpos.domain.Menu;
import com.github.callmewaggs.chickenpos.domain.Order;
import com.github.callmewaggs.chickenpos.domain.Table;
import java.util.List;

public class OutputView {
  private static final String TOP_LINE = "┌ ─ ┐";
  private static final String TABLE_FORMAT = "| %s |";
  private static final String BOTTOM_LINE = "└ ─ ┘";
  private static final String SPECIAL_BOTTOM_LINE = "└ ₩ ┘";

  public static void printTables(final List<Table> tables) {
    System.out.println("\n## 테이블 목록");
    final int size = tables.size();
    printLine(TOP_LINE, size, null);
    printTableNumbers(tables);
    printLine(BOTTOM_LINE, size, tables);
  }

  public static void printMenus(final List<Menu> menus) {
    for (final Menu menu : menus) {
      System.out.println(menu);
    }
  }

  private static void printLine(final String line, final int count, List<Table> tables) {
    for (int index = 0; index < count; index++) {
      if(!tables.get(index).isAvailable()) {
        System.out.println(SPECIAL_BOTTOM_LINE);
        continue;
      }
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
    System.out.println("\n## 주문 내역");
    System.out.println("메뉴 수량 금액");
    for(Order order : orders) {
      System.out.println(order);
    }
  }

  public static void printPrice(double totalPrice) {
    System.out.println("\n## 최종 결제할 금액");
    System.out.println(totalPrice + "원");
  }
}
