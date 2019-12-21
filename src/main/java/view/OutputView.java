package view;

import domain.model.MainOptions;
import domain.model.Menu;
import domain.model.Receipt;
import domain.model.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_HAS_ORDER = "└ ₩ ┘";
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String TABLE_TITLE = "## 테이블 목록";
    private static final String MENU_TITLE = "## 메뉴 목록";
    private static final String ORDER_TITLE = "## 전체 주문 내역";
    private static final String NUMBER_FORMAT_ERR = "유효한 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_ERR = "범위 내의 숫자가 아닙니다. %s 사이의 숫자를 입력해주세요.";
    private static final String TABLE_SELECT_MSG = "손님을 %d번 테이블로 안내합니다.";
    private static final String TABLE_ALREADY_SELECT_MSG = "사용할 수 없는 테이블입니다. 다시 선택해주세요.";
    private static final String MENU_NOT_EXIST_MSG = "존재하지 않는 메뉴입니다. 다시 선택해주세요.";
    private static final String PAYMENT_NOT_EXIST_MSG = "존재하지 않는 결제수단입니다. 다시 선택해주세요.";
    private static final String START_PAYMENT_MSG = "번 테이블의 결제를 시작합니다.";
    private static final String NO_ORDER_MSG = "등록된 주문이 없어 결제를 실패했습니다.";
    private static final String RESULT_PAYMENT_FORMAT = "%s(으)로 총 %d원을 결제합니다.";

    public static void printTables(final List<Table> tables, final boolean[] tableStatus) {
        System.out.println(TABLE_TITLE);
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tableStatus);
    }

    public static void printTableSelectSuccess(int tableNumber) {
        System.out.println(String.format(TABLE_SELECT_MSG, tableNumber));
    }

    public static void printTableSelectFail() {
        System.out.println(TABLE_ALREADY_SELECT_MSG);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println(MENU_TITLE);
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printNotExistMenu() {
        System.out.println(MENU_NOT_EXIST_MSG);
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final boolean[] tableStatus) {
        for (int i = 0; i < tableStatus.length; i++) {
            String line = BOTTOM_LINE;
            if (tableStatus[i]) {
                line = BOTTOM_LINE_HAS_ORDER;
            }
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

    public static void printNoOrder() {
        System.out.println(NO_ORDER_MSG);
    }

    public static void printOrder(Receipt receipt, int tableNumber) {
        System.out.println(ORDER_TITLE);
        System.out.println(receipt.toString());
        System.out.println(tableNumber + START_PAYMENT_MSG);
    }

    public static void printPaymentResult(String payType, int total) {
        System.out.println(String.format(RESULT_PAYMENT_FORMAT, payType, total));
    }

    public static void printNotExistPayment() {
        System.out.println(PAYMENT_NOT_EXIST_MSG);
    }

    public static void printNumberError() {
        System.out.println(NUMBER_FORMAT_ERR);
    }

    public static void printRangeError(String range) {
        System.out.println(String.format(NUMBER_RANGE_ERR, range));
    }
}
