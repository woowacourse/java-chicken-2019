package view;

import domain.Menu;
import domain.Table;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }




    public void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }


    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void printOrderHistory(Map<Menu, Integer> menus) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");

        for (Menu menu : menus.keySet()) {
            Integer price = calculatePrice(menu, menus.get(menu));
            List<String> menuInfo = Arrays.asList(menu.getName(), menus.get(menu).toString(), price.toString());
            System.out.println(String.join(" ", menuInfo));
        }
    }

    private Integer calculatePrice(Menu menu, Integer amount) {
        return menu.getPrice() * amount;
    }

    public void printGuideForPayment(int tableNumber) {
        System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", tableNumber));
    }

    public void printResult(double moneyToPay) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(String.format("%.0f원", moneyToPay));
    }

    public void printError(RuntimeException e) {
        System.out.println(String.format("다음과 같은 오류가 발생했습니다: %s", e.getMessage()));
    }

    public void printRessonOfOrder(int menuLimitNum) {
        System.out.println(String.format("한 테이블에서 %d보다 많이 주문할 수 없습니다.", menuLimitNum));
    }
}
