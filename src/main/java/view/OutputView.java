package view;

import domain.Menu;
import domain.Table;
import domain.Bill;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String IS_TABLE_BOTTOM_LINE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table: tables) {
            printBottomLine(table);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printBill(Table table) {
        List<Bill> bills = table.getBill();
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Bill bill: bills) {
            System.out.println(bill.getName() + " " + bill.getMenuNumber() + " " + bill.getPrice());
        }
        System.out.println();
    }

    public static void printTableBill(Table table) {
        System.out.println("## " + table.toString() + "번 테이블의 결제를 진행합니다.");
    }

    public static void printFinalBill(Table table) {
        System.out.println("## 최종 결제할 금액");
        System.out.println("");
        System.out.println();
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(Table table) {
        if (table.isTable()) {
            System.out.print(IS_TABLE_BOTTOM_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
