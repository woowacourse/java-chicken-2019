package view;

import domain.Menu;
import domain.Table;
import domain.TableRepository;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEW_LINE = "\n";
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
        StringBuilder order = new StringBuilder();
        boolean empty = true;

        for (Integer integer : orderCheck) {
            if (integer.equals(index)) {
                order.append(TABLE_HAVE_TO_PAY);
                empty = false;
            }
        }
        if (empty) {
            order.append(BOTTOM_LINE);
        }

        return order.toString();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMenu() {
        System.out.println(NEW_LINE + "## 메인 화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printReceipt(int tableNumber) {
        System.out.println(NEW_LINE + "## 주문 내역");
        System.out.println("메뉴  수량  금액");
        TableRepository.getTableMenu().get(tableNumber).getMenu().toString();
    }

    public static void printTotalPayment(int tableNumber) {
        System.out.println(NEW_LINE + "## 최종 결제할 금액");
        try {
            System.out.println((TableRepository.totalPayment(TableRepository.getTableMenu().get(tableNumber)) + "원"));
        } catch (NoSuchElementException e) {
            System.out.println("결제할 금액이 없습니다.");
        }
    }
}
