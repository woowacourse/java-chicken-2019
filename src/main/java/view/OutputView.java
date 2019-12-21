package view;

import domain.Functions;
import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MENU = " 메뉴 ";
    private static final String QUANTITY = " 수량 ";
    private static final String MONEY = " 금액";
    private static final String NEW_LINE = "\n";
    private static final String FINAL_MONEY_TO_PAY = "최종 결제 금액은, " + NEW_LINE;
    private static final String HERE = "입니다.";
    private static final String ERROR_AMOUNT = "99마리까지만 주문 할 수 있습니다."+NEW_LINE;

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
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

    public static void printMainFunctions() {
        System.out.println(Functions.REGISTER.toString());
    }

    public static void printTableBill(Table table) {
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(QUANTITY).append(MONEY);
        System.out.println(table.getMenus().toString());
    }

    public static void printTotalMoney(double totalMoney) {
        System.out.println(FINAL_MONEY_TO_PAY);
        System.out.println(totalMoney + HERE);
    }

    public static void printAmountError() {
        System.out.println(ERROR_AMOUNT);
    }
}
