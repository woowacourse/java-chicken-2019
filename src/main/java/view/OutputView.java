package view;

import domain.Menu;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_WHEN_NOT_ORDERED = "└ ─ ┘";
    private static final String BOTTOM_LINE_WHEN_ORDERED = "└ $ ┘";

    public static void printPosFunctions(final Map<Integer, String> posFunctions) {
        System.out.println("## 메인 화면");
        posFunctions.forEach(
            (key, value) -> System.out.println(key + " - " + value));
        System.out.println("\n");
    }

    public static void printTables(final List<Integer> tableNumbers,
        final List<Integer> orderedTableNumbers) {

        System.out.println("## 테이블 목록");
        final int size = tableNumbers.size();
        printTopLine(size);
        printTableNumbers(tableNumbers);
        printBottomLine(tableNumbers, orderedTableNumbers);
        System.out.println();
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(List<Integer> tableNumbers) {
        for (final int tableNumber : tableNumbers) {
            System.out.printf(TABLE_FORMAT, tableNumber + "");
        }
        System.out.println();
    }

    private static void printBottomLine(List<Integer> tableNumbers,
        List<Integer> orderedTableNumbers) {

        for (Integer tableNumber : tableNumbers) {
            printOneTableBottomLine(orderedTableNumbers.contains(tableNumber));
        }
        System.out.println();
    }

    private static void printOneTableBottomLine(boolean isOrderedTable) {
        if (isOrderedTable) {
            System.out.print(BOTTOM_LINE_WHEN_ORDERED);
            return;
        }
        System.out.print(BOTTOM_LINE_WHEN_NOT_ORDERED);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    public static void printOrderHistory(final Map<Menu, Integer> orderHistory) {
        System.out.println("메뉴\t수량\t금액");
        orderHistory.forEach((menu, count) ->
            System.out.println(menu.getName() + "\t" + count + "\t" + menu.getPrice())
        );
        System.out.println();
    }

    public static void printMakingPaymentMessage(int tableNumber) {
        System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printFinalPaymentAmount(int paymentAmount) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(paymentAmount + "원");
        System.out.println();
    }
}
