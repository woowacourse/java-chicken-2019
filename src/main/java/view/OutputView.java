package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String ORDERED_FORMAT = "└ %s ┘";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED = "$";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLineWithOrdered(tables);
    }

    public static void printBottomLineWithOrdered(List<Table> tables) {
        tables.stream().map(Table::isOrdered).map(OutputView::orderedOrNot).forEach(System.out::print);
        System.out.println();
    }

    public static String orderedOrNot(boolean ordered) {
        if (ordered) {
            return String.format(ORDERED_FORMAT, ORDERED);
        }

        return BOTTOM_LINE;
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

    public static void mainView() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록\n2 - 결제하기\n3 - 프로그램종료\n");
    }

    public static void printTableOrderedList(final Map<String, List<Menu>> menuAmount) {
        System.out.println("메뉴\t수량 금액");

        String amountMenu = menuAmount.keySet().stream()
                .map(x -> x + " " + menuAmount.get(x).size() + " "
                        + Objects.requireNonNull(menuAmount.get(x).stream().findAny().orElse(null)).getPrice())
                .collect(Collectors.joining("\n"));

        System.out.println(amountMenu);
    }

    public static void showSelectTableAsOrder() {
        System.out.println("## 주문할 테이블을 선택하세요.");
    }

    public static void showSelectTableAsPayment() {
        System.out.println("## 결제할 테이블을 선택하세요.");
    }

    public static void printFinalPrice(int price) {
        System.out.println("## 최종 결제할 금액\n" + price + "원\n");
    }

    public static void showNothingOrdered() {
        System.out.println("주문한 메뉴가 없는 테이블 입니다.");
    }
}
