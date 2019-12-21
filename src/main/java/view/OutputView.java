package view;

import domain.MainMenu;
import domain.Menu;
import domain.Table;
import domain.Tables;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String TABLE_ORDERED_FORMAT = "└ ￦ ┘";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    public static final String MESSAGE_NOT_INTEGER = "정수가 아닙니다. 다시 입력해주세요";

    public static void printTables(final Tables tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
        // printLine(BOTTOM_LINE, size);
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
        System.out.println();
    }

    public static void printInputMenuNumberException() {
        System.out.println("화면에 출력된 메뉴에 있는 숫자를 입력해주세요.");
    }

    public static void printInputTableNumberException() {
        System.out.println("화면에 출력된 테이블 정보에 있는 숫자를 입력해주세요.");
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(Tables tables) {
        tables.orderPrintTableNumbers();

        System.out.println();
    }

    public static void printTableNumber(Table table) {
        System.out.printf(TABLE_FORMAT, table);
    }

    private static void printBottomLine(Tables tables) {
        tables.orderPrintBottomState();
        System.out.println();
    }

    public static void printOrderedFormat() {
        System.out.print(TABLE_ORDERED_FORMAT);
    }

    public static void printBottomLine() {
        System.out.print(BOTTOM_LINE);
    }

    public static void printNotInteger() {
        System.out.println(MESSAGE_NOT_INTEGER);
    }
}
