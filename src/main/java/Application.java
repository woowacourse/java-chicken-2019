import domain.Discount;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	private static final int MENU_ORDER = 1;
	private static final int MENU_PAYMENT = 2;
	private static final int MENU_EXIT = 3;
	private static final int PAYMENT_CREDITCARD = 1;
	private static final int PAYMENT_CASH = 2;
	
	private static final List<Table> tables = TableRepository.tables();
	private static final List<Menu> menus = MenuRepository.menus();

	public static void main(String[] args) {
		while (true) {
			int mainMenuNumber = mainMenu();
			if (mainMenuNumber == MENU_ORDER) {
				orderMenu();
			}
			if (mainMenuNumber == MENU_PAYMENT) {
				paymentMenu();
			}
			if (mainMenuNumber == MENU_EXIT) {
				break;
			}
		}
	}

	private static int mainMenu() {
		try {
			OutputView.printMainMenu();
			final int mainMenuNumber = InputView.inputMainMenuNumber();
			return mainMenuNumber;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	private static void orderMenu() {
		try {
			OutputView.printTables(tables);
			final int tableNumber = InputView.inputTableNumber();
			if (TableRepository.getTable(tableNumber) == null) {
				System.err.println("존재하지 않는 테이블입니다.");
				return;
			}
			OutputView.printMenus(menus);
			final int selectedMenu = InputView.inputMenuSelect();
			final int menuCount = InputView.inputMenuCount();
			TableRepository.addMenu(tableNumber, selectedMenu, menuCount);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static void paymentMenu() {
		try {
			OutputView.printTables(tables);
			final int tableNumber = InputView.inputTableNumber();
			final Table table = TableRepository.getTable(tableNumber);
			if (table == null || !table.hasCustomer()) {
				System.err.println("결제할 수 없는 테이블입니다.");
				return;
			}
			calculateAll(tableNumber, table);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void calculateAll(int tableNumber, Table table) {
		try {
			OutputView.printTableMenu(tableNumber);
			int price = Discount.discountByChickenCount(Table.getPrice(), table);
			if (InputView.inputPaymentMenuNumber() == PAYMENT_CASH) {
				price = Discount.discountByCash(price);
			}
			OutputView.printPrice(price);
			table.reset();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
