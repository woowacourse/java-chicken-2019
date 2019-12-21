package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_WHEN_PAYMENT_TOBE_DONE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for(Table table: tables){
            if(table.tableHasMenu()){
                printBottomLine(BOTTOM_LINE_WHEN_PAYMENT_TOBE_DONE);
            }
            if(!table.tableHasMenu()){
                printBottomLine(BOTTOM_LINE);
            }
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

    private static void printBottomLine(final String line) {
        System.out.print(line);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printProgramEnding(){
        System.out.println("프로그램 종료");
    }

    public static void printOrderHistory(Table table){
        System.out.println("## 주문 내역");
        System.out.println("메뉴 \t 수량 \t 금액");

    }
}
