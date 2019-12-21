package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;
import java.util.Map;

/**
 * 콘솔 출력을 담당하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "|  %s  |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_CASH_LINE = "└ $ ┘";
	private static final String END_POS_MESSAGE = "## 포스기를 종료합니다.";
	private static final String TABLE_LIST_GUIDE_MESSAGE = "## 테이블 목록";
	private static final String ORDER_COUNT_EXCEED_MESSAGE =
			"## 최대 주문 제한 개수를 초과하여 구매할 수 없습니다.";
	private static final String NOT_HAS_UNPAID_TABLE_MESSAGE = "## 결제할 테이블이 없습니다.";
	private static final String ORDER_LIST_GUIDE_MESSAGE = "## 주문 내역";
	private static final String MENU_COUNT_PRICE_GUIDE_MESSAGE = "메뉴 수량 금액";
	private static final String FINAL_PAYMENT_MESSAGE = "## 최종 결제할 금액";
	private static final String WON = "원";

	// 묵시적 생성자 방지
	private OutputView() {}

	public static void printEndPos() {
		System.out.println(END_POS_MESSAGE);
	}

	public static void printTables(final List<Table> tables, Map<Table, List<Order>> tableOrders) {
		System.out.println(TABLE_LIST_GUIDE_MESSAGE);
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printTableBottomLine(tables, tableOrders);
	}

	public static void printOrderCountExceed() {
		System.out.println(ORDER_COUNT_EXCEED_MESSAGE);
	}

	public static void printNotHasUnpaidTable() {
		System.out.println(NOT_HAS_UNPAID_TABLE_MESSAGE);
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

	private static void printTableBottomLine(final List<Table> tables, Map<Table, List<Order>> tableOrders) {
		for (final Table table : tables) {
			printTableBottomLine(tableOrders.get(table).size());
		}
		System.out.println();
	}

	private static void printTableBottomLine(int tableOrderCount) {
		if (tableOrderCount == 0) {
			System.out.print(BOTTOM_LINE);
		}
		if (tableOrderCount != 0) {
			System.out.print(BOTTOM_CASH_LINE);
		}
	}

	public static void printOrders(List<Order> orders) {
        System.out.println(ORDER_LIST_GUIDE_MESSAGE);
        System.out.println(MENU_COUNT_PRICE_GUIDE_MESSAGE);
		for (Order order: orders) {
            printOrder(order);
		}
		System.out.println();
	}

	private static void printOrder(Order order) {
        System.out.println(order.toPrintString());
	}

	public static void printPaymentPrice(int price) {
		System.out.println(FINAL_PAYMENT_MESSAGE);
		System.out.println(price + WON);
	}
}
