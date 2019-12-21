package view;

import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDER = "└ \\ ┘";
    private static final int CASH = 2;
    private static final double CASH_DISCOUNT = 0.05;

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println();
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
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

    private static void printBottomLine(final List<Table> tables) {
        for (int index = 0; index < tables.size(); index++) {
            if (tables.get(index).getOrderMenu().size() == 0)
                System.out.print(BOTTOM_LINE);
            if (tables.get(index).getOrderMenu().size() != 0)
                System.out.print(BOTTOM_LINE_ORDER);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderMenus(final List<Table> tables, final List<Menu> menus, final int tableNumber) {
        HashMap<Menu, Integer> orderMenu = tables.get(tableNumber).getOrderMenu();
        if (orderMenu.size() == 0) {
            System.out.println("!!주문 내역이 없습니다. 주문을 먼저 해주세요.");
            return;
        }

        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Map.Entry<Menu, Integer> order : orderMenu.entrySet()) {
            Menu menu = order.getKey();
            System.out.println(menu.getName() + " " + order.getValue() + " " + menu.getPrice());
        }
        System.out.println();
    }

    public static void printMoney(final List<Table> tables, final int tableNumber, final int payNumber) {
        int totalMoney = tables.get(tableNumber).getTotalMoney();
        
        if (payNumber == CASH)
            totalMoney -= totalMoney * CASH_DISCOUNT;

        System.out.println("## 최종 결제할 금액");
        System.out.println(totalMoney + "원");
        tables.get(tableNumber).clearTable();
    }
}
