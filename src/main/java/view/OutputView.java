package view;

import domain.MainOptions;
import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String NUMBER_FORMAT_ERR = "유효한 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_ERR = "범위 내의 숫자가 아닙니다.";

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

    public static void printMain(MainOptions[] options) {
        System.out.println(MAIN_TITLE);
        for (MainOptions option : options) {
            System.out.println(option);
        }
    }

    public static void printNumberError() {
        System.out.println(NUMBER_FORMAT_ERR);
    }

    public static void printRangeError() {
        System.out.println(NUMBER_RANGE_ERR);
    }
}
