/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 모든 출력문을 담당하는 클래스입니다.
 * @since : 2019.12.23 월요일
 */
public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String CHECKED_BOTTOM_LINE = "└ * ┘";
    private static final String MAIN_PAGE = "\n## 메인화면";
    private static final String PRINT_MAIN_FUNCTION = "1 - 주문등록 \n2 - 결제하기 \n3 - 프로그램 종료";
    private static final String ASK_TO_CHOOSE_MAIN_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    private static final String ASK_REENTER_ONLY_INTEGER = "입력이 정수가 아닙니다. 다시 입력하세요.";
    private static final String ASK_PUT_ONLY_MAIN_FUNC_MENU_NUMBER = "1, 2, 3 중에 입력하세요.";
    private static final String ASK_TO_CHOOSE_TABLE_NUMBER = "\n## 테이블을 선택하세요.";
    private static final String ASK_REENTER_NUMBER_IN_LIST = "목록에 있는 번호만 입력하세요.";
    private static final String ASK_TO_CHOOSE_MENU_NUMBER = "\n## 등록할 메뉴를 선택하세요.";
    private static final String ASK_TO_CHOOSE_QUANTITY = "\n## 메뉴의 수량을 입력하세요.";
    private static final String ASK_REENTER_ORDER_QUANTITY = "주문은 1개 이상 99개 이하만 가능합니다.";
    private static final String TABLE_LIST = "\n## 테이블 목록";
    private static final String ORDER_LIST = "\n## 주문 내역";
    private static final String MENU_QUANTITY_PRICE = "주문 수량 금액";
    private static final String TABLE_IS_NOT_ORDERED_YET = "주문을 안한 테이블을 계산하려합니다.";
    private static final String LINE_BREAK = "\n";
    private static final String NO_ORDERED_TABLES_GO_BACK_TO_MAIN = "주문된 테이블이 없습니다. 초기화면으로 돌아갑니다.\n";
    private static final String N_TABLE_WILL_BE_PAYED = "\n## %s번 테이블의 결제를 진행합니다.\n";
    private static final String CARD_OR_CASH = "## 신용 카드는 1번, 현금은 2번";
    private static final String TOTAL_PAYING_PRICE = "\n## 최종 결제할 금액\n";
    private static final String WON = "원";


    public static void printTables(final List<Table> tables, List<Table> orderedTables) {
        StringBuilder checkingBottomLine = new StringBuilder();
        for (Table table : tables) {
            if (table.isInTables(orderedTables)){
                checkingBottomLine.append(CHECKED_BOTTOM_LINE);
                continue;
            }
            checkingBottomLine.append(BOTTOM_LINE);
        }
        System.out.println(TABLE_LIST);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        System.out.println(checkingBottomLine);
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

    public static void printOrderListTitle() {
        System.out.println(ORDER_LIST);
    }

    public static void printMenuQuantityPrice() {
        System.out.println(MENU_QUANTITY_PRICE);
    }

    public static void printValueOfMenuQuantityPrice(Order order) {
        System.out.printf("%s %d %d\n", order.getOrderName(), order.getQuantity(), order.getPrice());
    }

    public static void printTableIsNotOrderedYet() {
        System.out.println(TABLE_IS_NOT_ORDERED_YET);
    }

    public static void breakLine() {
        System.out.println(LINE_BREAK);
    }

    public static void printNoOrderedTableGoBackToMain() {
        System.out.println(NO_ORDERED_TABLES_GO_BACK_TO_MAIN);
    }

    public static void printTableWillBePayed(int tableNumber) {
        System.out.printf(N_TABLE_WILL_BE_PAYED, tableNumber);
    }

    public static void printCardOrCash() {
        System.out.println(CARD_OR_CASH);
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PAYING_PRICE + totalPrice + WON);
    }
}
