package view;

import domain.menu.Menu;
import domain.table.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTM_LINE_ORDERED = "└ ￦ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(BOTTOM_LINE, BOTTM_LINE_ORDERED, tables);
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

    /**
     * printBottomLine은 table의 목록을 순회하면서 만약 주문이 있다면 표시해주는 메서드이다.
     * 현재 구현 수준이 매우 낮아, 개선이 필요하다. 값 출력되는 것 확인 후 바로 개선할 예정.
     *
     * @param line 일반 상황에서 그릴 라인
     * @param orderLine 주문이 있는 테이블에 그릴 라인
     * @param tables 테이블의 목록
     */
    private static void printBottomLine(final String line, final String orderLine, final List<Table> tables){
        for (Table table : tables) {
            if(table.isOrderEmpty()){
                System.out.print(line);
                continue;
            }
            System.out.print(orderLine);
        }
    }
    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printTodoChoices() {
        System.out.println("## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n");
    }
}
