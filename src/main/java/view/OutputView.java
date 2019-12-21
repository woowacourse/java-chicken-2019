package view;

import domain.Menu;
import domain.ProvidingFunction;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String PROVIDING_FUNCTION_FORMAT = "%d - %s";

    public static void printProvidingFunctions(final List<ProvidingFunction> providingFunctions) {
        System.out.println("## 메인화면");

        for (ProvidingFunction providingFunction : providingFunctions) {
            printProvidingFunction(providingFunction);
            System.out.println();
        }

    }

    private static void printProvidingFunction(final ProvidingFunction providingFunction) {
        System.out.printf(PROVIDING_FUNCTION_FORMAT, providingFunction.getId(), providingFunction.getDescription());
    }

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
}
