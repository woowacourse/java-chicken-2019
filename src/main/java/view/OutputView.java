package view;

import domain.Menu;
import domain.Table;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_WITH_WON = "└ " + Currency.getInstance(Locale.KOREA).getSymbol() + " ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLines(tables);
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
    
    private static void printBottomLines(final List<Table> tables) {
        for (Table table : tables) {
            printBottomLine(table);
        }
        System.out.println();
    }
    
    private static void printBottomLine(final Table table) {
        if (table.isEmptyMenus()) {
            System.out.print(BOTTOM_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE_WITH_WON);

    }
    
    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
    
    public static void printTableOrder(final Table table) {
        System.out.println("## 주문내역 \n메뉴 수량 금액");
        System.out.println(table.getMenusString());
    }
    
    public static void printTablePay(final Table table, int paymentNumber) {
        System.out.println("##" + table.toString() + "번 테이블의 결제를 진행합니다.\n");
        System.out.println("## 최종 결제할 금액\n" + table.getFinalPrice(paymentNumber) + "원");
    }
}
