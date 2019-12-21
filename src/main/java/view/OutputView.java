package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ %s ┘";

    public static void printFunctions() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printExit() {
        System.out.println("종료되었습니다.");
    }

    public static void printTotal() {
        System.out.println("##최종 결제할 금액");
    }

    public static void printSelectPayment(int tableNumber) {
        System.out.println("##" + tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
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

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            if (table.isOrder()) {
                System.out.printf(BOTTOM_LINE, 'W');
            } else {
                System.out.printf(BOTTOM_LINE, '-');
            }
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

    public static void printOverQuantity() {
        System.out.println("너무 많은 수량을 시켰습니다. 다시 입력해주세요");
    }

}
