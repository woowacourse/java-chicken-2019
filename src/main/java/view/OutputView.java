package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {

  private static final String TOP_LINE = "┌ ─ ┐";
  private static final String TABLE_FORMAT = "| %s |";
  private static final String BOTTOM_LINE = "└ ─ ┘";
  private static final String ORDERED_BOTTOM_LINE = "└ $ ┘";

  public static void printTables(final List<Table> tables) {
    System.out.println("## 테이블 목록");
    final int size = tables.size();
    printLine(TOP_LINE, size);
    printTableNumbers(tables);
    printBottomLine(tables);
  }

  public static void printPrice(int price){
      System.out.println("## 최종 결제할 금액");
      System.out.println(price+"원");
  }

  public static void printOrderResult(Table table){
      System.out.println("## 메뉴  수량  금액");
      System.out.println(table.getOrderResult());
  }

  public static void printBottomLine(List<Table> tables) {
    for (Table table : tables) {
      if (table.hasOrdered()) {
        System.out.print(ORDERED_BOTTOM_LINE);
        continue;
      }
      System.out.print(BOTTOM_LINE);
    }
    System.out.println();
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
}
