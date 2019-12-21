package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MAIN_PAGE = "## 메인화면";
    private static final String PRINT_MAIN_FUNCTION = "1 - 주문등록 \n2 - 결제하기 \n3 - 프로그램 종료";
    private static final String ASK_TO_CHOOSE_MAIN_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    private static final String ASK_REENTER_ONLY_INTEGER = "입력이 정수가 아닙니다. 다시 입력하세요.";
    private static final String ASK_PUT_ONLY_MAIN_FUNC_MENU_NUMBER = "1, 2, 3 중에 입력하세요.";
    private static final String ASK_TO_CHOOSE_TABLE_NUMBER = "## 테이블을 선택하세요.";
    private static final String ASK_REENTER_NUMBER_IN_LIST = "목록에 있는 번호만 입력하세요.";
    private static final String ASK_TO_CHOOSE_MENU_NUMBER = "\n## 등록할 메뉴를 선택하세요.";
    private static final String ASK_TO_CHOOSE_QUANTITY = "\n## 메뉴의 수량을 입력하세요.";
    private static final String ASK_REENTER_ORDER_QUANTITY = "주문은 1개 이상 99개 이하만 가능합니다.";


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

    public static void printMainPage() {
        System.out.println(MAIN_PAGE);
    }

    public static void printMainFunction() {
        System.out.println(PRINT_MAIN_FUNCTION);
        System.out.println(ASK_TO_CHOOSE_MAIN_FUNCTION);
    }

    public static void askReenterOnlyInteger() {
        System.out.println(ASK_REENTER_ONLY_INTEGER);
    }

    public static void askPutOnlyMainFuncMenuNumber() {
        System.out.println(ASK_PUT_ONLY_MAIN_FUNC_MENU_NUMBER);
    }

    public static void askToChooseTableNumber() {
        System.out.println(ASK_TO_CHOOSE_TABLE_NUMBER);
    }

    public static void askReenterNumberInList() {
        System.out.println(ASK_REENTER_NUMBER_IN_LIST);
    }

    public static void askToChooseMenuNumber() {
        System.out.println(ASK_TO_CHOOSE_MENU_NUMBER);
    }

    public static void askToChooseQuantity() {
        System.out.println(ASK_TO_CHOOSE_QUANTITY);
    }

    public static void askReenterOrderQuantity() {
        System.out.println(ASK_REENTER_ORDER_QUANTITY);
    }
}
