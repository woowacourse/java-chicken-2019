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
        System.out.println();
    }

    public static void printTables(final List<Integer> tableNumbers,
        final List<Integer> orderedTableNumbers) {

        System.out.println("## 테이블 목록");
        final int size = tableNumbers.size();
        printTopLine(size);
        printTableNumbers(tableNumbers);
        printBottomLine(size, orderedTableNumbers);
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

    private static void printBottomLine(int count, List<Integer> orderedTableNumbers) {
        for (int tableNumber = 1; tableNumber <= count; tableNumber++) {
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
    }
}
