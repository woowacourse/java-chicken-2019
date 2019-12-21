package view;

import domain.Menu;
import domain.Table;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String TABLE_HAVE_TO_PAY = "└ ₩ ┘";

    public static void printTables(final List<Table> tables, List<Integer> orderCheck) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);

        for (int i = 0; i < tables.size(); i++) {
            System.out.print(printPayLine(i, orderCheck));
        }
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

    private static String printPayLine(int index, List<Integer> orderCheck) {
        String order = "";
        boolean empty = true;

        for (int i = 0; i < orderCheck.size(); i++) {
            if (orderCheck.get(i).equals(index)) {
                order += TABLE_HAVE_TO_PAY;
                empty = false;
            }
        }
        if (empty) {
            order += BOTTOM_LINE;
        }

        return order;
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }
}
