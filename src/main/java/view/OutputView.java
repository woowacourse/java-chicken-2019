package view;

import domain.Menu;
import domain.Table;
import domain.repository.TableRepository;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	public static final String ERROR = "[ERROR] ";
	public static final String PAY = "## 최종 결제할 금액\n%d원\n";
	public static final String TABLE_MENUS = "## 주문 내역\n"
		+ "메뉴 수량 금액";

	public static void printMainList() {
		System.out.println("## 메인화면\n"
			+ "1 - 주문등록\n"
			+ "2 - 결제하기\n"
			+ "3 - 프로그램 종료\n");
	}

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
		printBreak();
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
		printBreak();
	}

	public static void printError(String message) {
		System.out.println(ERROR + message);
		printBreak();
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		printBreak();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		printBreak();
	}

	public static void printPayMoney(int payMoney) {
		System.out.printf(PAY, payMoney);
		printBreak();
	}

	public static void printBreak() {
		System.out.println();
	}

	public static void printTableMenus(int tableNumber) {
		System.out.println(TABLE_MENUS);
		for (String menu : TableRepository.getUser(tableNumber).getMenus()) {
			System.out.println(menu);
		}
		printBreak();
	}
}
