package view;

import domain.Menu;
import domain.Orders;
import domain.Price;
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
    private static final String TOTAL_PAYMENT_MESSAGE = "## 최종 결제할 금액";
    private static final String WON = "원";
    private static final String RE_ENTER_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
    private static final String NO_ORDER_MESSAGE = "주문이 없습니다.";
	private static final String NO_ORDER_IN_TABLE_MESSAGE = "입력 하신 테이블엔 주문이 없습니다.";
	private static final String INVALID_MENU_NUMBER_MESSAGE = "메뉴에 없는 번호 입력입니다.";

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
		System.out.println(orders.getMenuAccounts(tableNumber));
	}

	public static void printTotalPayment(Price price) {
    	System.out.println(TOTAL_PAYMENT_MESSAGE);
    	System.out.println(price.getPrice() + WON);
	}

	public static void printReEnter() {
    	System.out.println(RE_ENTER_MESSAGE);
	}

	public static void printNoOrderInTable() {
    	System.out.println(NO_ORDER_IN_TABLE_MESSAGE);
	}

	public static void printNoOrder() {
    	System.out.println(NO_ORDER_MESSAGE);
	}

	public static void printInvalidMenuNumber() {
		System.out.println(INVALID_MENU_NUMBER_MESSAGE);
	}
}
