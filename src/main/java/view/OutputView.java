package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ \\ ┘";

    public static void printTables(final List<Table> tables) {
	System.out.println("## 테이블 목록");
	final int size = tables.size();
	printLine(TOP_LINE, size);
	printTableNumbers(tables);
	printBottomLine(size, tables);
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

    private static void printBottomLine(final int count, final List<Table> tables) {
	for (int index = 0; index < count; index++) {
	    System.out.print(printWhichLine(tables.get(index)));
	}
	System.out.println();
    }

    public static String printWhichLine(Table table) {
	if (table.getOrderd()) {
	    return BOTTOM_LINE_ORDERED;
	}
	return BOTTOM_LINE;
    }

    private static void printTableNumbers(final List<Table> tables) {
	for (final Table table : tables) {
	    System.out.printf(TABLE_FORMAT, table);
	}
	System.out.println();
    }

    public static void printMainScreen() {
	System.out.println("## 메인화면");
	System.out.println("1 - 주문등록");
	System.out.println("2 - 결제하기");
	System.out.println("3 - 프로그램 종료");

    }

    public static void printFuctionSelectError() {
	System.out.println("기능 입력이 잘못되었습니다. 1,2,3 중 하나의 숫자만 입력해주세요.");
    }

    public static void printTaleSelectError() {
	System.out.println("테이블 입력이 잘못되었습니다. 가능한 테이블 목록만 입력해주세요.");
    }

    public static void printTableFullError() {
	System.out.println("테이블의 주문이 꽉 찼습니다. 다른 테이블을 입력해주세요.");
    }

    public static void printMenuSelectError() {
	System.out.println("메뉴 입력이 잘못되었습니다. 가능한 메뉴 목록만 입력해주세요.");
    }

    public static void printMenutAmountError() {
	System.out.println("수량 입력이 잘못되었습니다. 0이상의 숫자만 입력해주세요.");
    }

    public static void printMenuAmountInputError() {
	System.out.println("주문 가능한 수량을 넘어섰습니다. 총 주문량이 99개 이하가 되도록 주문해주세요.");
    }

    public static void printOrderList(Table table, List<Menu> menus) {
	System.out.println("메뉴  수량  금액");
	for (int i = 0; i < 6; i++) {
	    int tmpChickenMenu = table.getChickenMenu()[i];
	    if (tmpChickenMenu != 0) {
		System.out.println(
			menus.get(i).getName() + " " + tmpChickenMenu + " " + menus.get(i).getPrice() * tmpChickenMenu);
	    }
	}
	for (int i = 0; i < 2; i++) {
	    int tmpDrinkMenu = table.getDrinkMenu()[i];
	    if (tmpDrinkMenu != 0) {
		System.out.println(menus.get(i + 6).getName() + " " + tmpDrinkMenu + " "
			+ menus.get(i + 6).getPrice() * tmpDrinkMenu);
	    }
	}
    }

    public static void printPayInputError() {
	System.out.println("결제방식 입력이 잘못되었습니다. 1또는 2만 입력해주세요.");
    }

    public static void printPrice(Table table, List<Menu> menus, int pay) {
	System.out.println("## 최종 결제할 금액");
	if (pay == 1) {
	    System.out.println(table.getChickenPrice()+table.getDrinkPrice());
	}
	if(pay==2) {
	    System.out.println(((float)table.getChickenPrice()+(float)table.getDrinkPrice())*0.9);
	}
	
    }
}
