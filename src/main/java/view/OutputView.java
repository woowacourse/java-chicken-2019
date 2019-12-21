package view;

import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_OREDR = "└ ₩ ┘";

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

    public static void printOrderPage() {
        System.out.println("## 메인화면");
        System.out.println("1. 주문등록");
        System.out.println("2. 결제하기");
        System.out.println("3. 프로그램 종료");
    }

    public static void printOrderTable(HashMap<Integer, Integer> orderTable, final List<Table> tables) {
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for(Table table : tables) {
            if(orderTable.containsKey(table.getNumber())) {
                System.out.print(BOTTOM_LINE_OREDR);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    public static void eachPayment(Menu menu, int menuCount) {
        System.out.println(menu.getName() +" "+ menuCount + " " + menu.getPrice()*menuCount);
    }

    public static void moneyPayment(int allPayment) {
        System.out.println("최종 결제할 금액 " + (int)(allPayment * 0.95));
    }

    public static void cardPayMent(int allPayment) {
        System.out.println("최종 결제할 금액 " + allPayment);
    }
}
