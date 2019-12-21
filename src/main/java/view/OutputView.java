package view;

import domain.model.MainOptions;
import domain.model.Menu;
import domain.model.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String TABLE_TITLE = "## 테이블 목록";
    private static final String NUMBER_FORMAT_ERR = "유효한 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_ERR = "범위 내의 숫자가 아닙니다.";
    private static final String TABLE_SELECT_MSG = "손님을 %d번 테이블로 안내합니다.";
    private static final String TABLE_ALREADY_SELECT_MSG = "사용할 수 없는 테이블입니다. 다시 선택해주세요.";
    private static final String MENU_NOT_EXIST_MSG = "존재하지 않는 메뉴입니다. 다시 선택해주세요.";

    public static void printTables(final List<Table> tables) {
        System.out.println(TABLE_TITLE);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printTableSelectSuccess(int tableNumber) {
        System.out.println(String.format(TABLE_SELECT_MSG, tableNumber));
    }

    public static void printTableSelectFail() {
        System.out.println(TABLE_ALREADY_SELECT_MSG);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printNotExistMenu() {
        System.out.println(MENU_NOT_EXIST_MSG);
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
