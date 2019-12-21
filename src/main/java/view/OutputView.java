package view;

import domain.Menu;
import domain.Table;
import order.OrderList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ACTIVE_BOTTOM_LINE = "└ \\ ┘";

    public static void printTables(final List<Table> tables, HashMap<Table, OrderList> orderList) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table : tables)
            printBottomLine(BOTTOM_LINE, ACTIVE_BOTTOM_LINE, orderList.get(table).isActive());
        System.out.println("\n");
    }

    private static void printBottomLine(String line1, String line2, boolean active) {
        if (active) {
            System.out.print(line2);
            return;
        }
        System.out.print(line1);
    }

    public static void printMainMenu() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");
    }

    public static void printOrderHistory(ArrayList<String> orderList) {
        System.out.println("## 주문내역");
        System.out.println("메뉴 수량 금액");
        for (String order : orderList)
            System.out.println(order);
        System.out.println();
    }

    public static void printFinalPaymontAmount(int price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price + "원");
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
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
