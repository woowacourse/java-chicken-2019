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
	
	public static void main(String[] args) {
		while(true) {
			int mainMenuNumber = mainMenu();
			if(mainMenuNumber == MENU_ORDER) {
				orderMenu();
			}
			if(mainMenuNumber == MENU_PAYMENT) {
				paymentMenu();
			}
			if(mainMenuNumber == MENU_EXIT) {
				break;
			}
		}
	}

	private static int mainMenu() {
		OutputView.printMainMenu();
		final int mainMenuNumber = InputView.inputMainMenuNumber();
		return mainMenuNumber;
	}
	
	private static void orderMenu() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
		final int selectedMenu = InputView.inputMenuSelect();
		final int menuCount = InputView.inputMenuCount();
		TableRepository.addMenu(tableNumber, selectedMenu, menuCount);
	}
	
	private static void paymentMenu() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		OutputView.printTableMenu(tableNumber);
		InputView.inputPaymentMenuNumber();
	}
}
