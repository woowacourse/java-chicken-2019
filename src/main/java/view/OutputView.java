package view;

import domain.Menu;
import domain.Orders;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_IN_ORDER = "└ ₩ ┘";
    private static final String MAIN_SCREEN_MESSAGE = "## 메인화면";
    private static final String[] FUNCTION_LINES = {"1 - 주문등록", "2 - 결제하기", "3 - 프로그램 종료"};
    private static final String[] MENU_ACCOUNTS_MESSAGES = {"## 주문내역", "메뉴\t수량\t금액"};

    public static void printTables(final List<Table> tables, Orders orders) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(orders, size);
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

    private static void printBottomLine(Orders orders, final int count) {
    	for (int i = 0; i < count; i++) {
			if (orders.isOrderIn(TableRepository.tables().get(i).getNumber())) {
				System.out.print(BOTTOM_LINE_IN_ORDER);
				continue;
			}
			System.out.print(BOTTOM_LINE);
		}
		System.out.println();
	}

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN_MESSAGE);
        for (String functionLine : FUNCTION_LINES) {
            System.out.println(functionLine);
        }
    }

    public static void printMenuAccounts(int tableNumber, Orders orders) {
		for (String message : MENU_ACCOUNTS_MESSAGES) {
			System.out.println(message);
		}
		if (!orders.isOrderIn(tableNumber)) {
			throw new IllegalArgumentException("주문이 없습니다.");
		}
		System.out.println(orders.getMenuAccounts(tableNumber));
	}
}
