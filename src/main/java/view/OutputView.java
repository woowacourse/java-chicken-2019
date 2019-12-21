package view;

import domain.Menu;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String REGISTER_BOTTOM_LINE = "└ \\ ┘";
    public static boolean[] checkOrder;

    public static void printMain(){
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(size);
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

    private static void printBottomLine(final int count){
        for (int index = 0; index < count; index++) {
            System.out.println(checkOrderFunc(index));
        }
        System.out.println();
    }

    private static String checkOrderFunc(int index){
        if(checkOrder[index]){
            return REGISTER_BOTTOM_LINE;
        }
        return BOTTOM_LINE;
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printExitProgram(){
        System.out.println("프로그램을 종료합니다");
    }

    public static void printOrderHistory(int tableNumber){
        System.out.println("메뉴 | 메뉴번호 | 수량 | 금액");
        System.out.println(TableRepository.getSelectTable(tableNumber).getMenuHistoryStr());
    }

    public static void printPayment(int tableNumber){
        System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
    }

}
