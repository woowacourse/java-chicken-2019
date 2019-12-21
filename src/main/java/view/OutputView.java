package view;

import domain.Amount;
import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_BOTTOM_LINE = "└ $ ┘";

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table : tables) {
            printBottomLine(table);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printBottomLine(Table table) {
        if (table.hasMenu()) {
            System.out.print(ORDER_BOTTOM_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE);
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

    public static void printOrderHistory(HashMap<Menu, Amount> bill) {
        StringBuilder sb = new StringBuilder();

        sb.append("## 주문 내역\n");
        sb.append("메뉴 수량 금액\n");
        printBill(sb, bill);
        System.out.println(sb);
    }

    private static void printBill(StringBuilder sb, HashMap<Menu, Amount> bill) {
        for (Map.Entry<Menu, Amount> entry : bill.entrySet()) {
            sb.append(entry.getKey().getName() + " ");
            sb.append(entry.getValue().getAmount() + " ");
            sb.append(entry.getKey().getPrice() * entry.getValue().getAmount() + "\n");
        }
    }

    public static void printTotalPrice(int price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price + "원");
    }
}
