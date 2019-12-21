package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

//    public static void printFunctions(final List<String> functions) {
//        System.out.println("## 메인화면");
//        for (final String names : functions) {
//            System.out.println(functions);
//        }
//        printLine(TOP_LINE, size);
//        printTableNumbers(tables);
//        printLine(BOTTOM_LINE, size);
//    }

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


    /*예외처리 문장들*/
    public static void printNonexistTableNumbers() {
        System.out.println("존재하지 않는 테이블입니다. 다시 입력해주세요");
    }

    public static void printNonexistMenuNumbers() {
        System.out.println("존재하지 않는 메뉴입니다. 다시 입력해주세요");
    }

}
