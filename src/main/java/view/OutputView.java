package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

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

    public static void printMainFeatures(List<String> mainFeatureList) {
        System.out.println("## 메인화면");
        int startFeatureNumber = 1;
        for (int i = 0; i < mainFeatureList.size(); i++) {
            System.out.println(i + startFeatureNumber + " - " + mainFeatureList.get(i));
        }
    }

    public static void printIsNotNumberError() {
        System.out.println("입력된 데이터는 숫자가 아닙니다.\n");
    }

    public static void printIsNotFeatureNumberError() {
        System.out.println("입력된 숫자는 기능목록에 포함되지 않습니다.\n");
    }
}
