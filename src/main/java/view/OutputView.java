package view;

import domain.MainMenu;
import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    public static final String SPACEBAR = "";

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

    public static void printMainMenu(final List<MainMenu> mainMenus) {
        System.out.println("## 메인 화면");
        for (final MainMenu mainMenu : mainMenus) {
            System.out.println(mainMenu);
        }
        printSpacebar();
    }

    public static void printInputMenuNumberException() {
        System.out.println("화면에 출력된 메뉴에 있는 숫자를 입력해주세요.");
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

    private static void printSpacebar() {
        System.out.println(SPACEBAR);
    }

}
