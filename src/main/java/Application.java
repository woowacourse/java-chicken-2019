import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import util.InputUtil;
import util.OneOrTwoOrThree;
import view.InputView;
import view.OutputView;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		while (true) {
			OneOrTwoOrThree mainMenuNumber = getMainMenuNumber();
			if (mainMenuNumber.isThree()) {
				System.exit(0);
			}

			final List<Table> tables = TableRepository.tables();
			int tableNumber = getTableNumber(tables);
			if (mainMenuNumber.isOne()) {
				orderByTable(tableNumber);
			}
			if (mainMenuNumber.isTwo()) {

			}
		}
	}

	private static OneOrTwoOrThree getMainMenuNumber() {
		OneOrTwoOrThree mainMenuNumber;

		try {
			OutputView.printMainMenu();
			mainMenuNumber = InputUtil.checkMainMenuNumber(InputView.inputMainMenuNumber());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return getMainMenuNumber();
		}
		return mainMenuNumber;
	}

	private static int getTableNumber(List<Table> tables) {
		int tableNumber;

		try {
			OutputView.printTables(tables);
			tableNumber = InputUtil.checkTableNumber(InputView.inputTableNumber()).getValue();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return getTableNumber(tables);
		}
		return tableNumber;
	}

	private static void orderByTable(int tableNumber) {
		final List<Menu> menus = MenuRepository.menus();
		int menuNumber = getMenuNumber(menus);
	}

	private static int getMenuNumber(List<Menu> menus) {
		int menuNumber;

		try {
			OutputView.printMenus(menus);
			menuNumber = InputUtil.checkMenuNumber(InputView.inputMenuNumber()).getValue();
		} catch (IllegalArgumentException e) {
			return getMenuNumber(menus);
		}
		return menuNumber;
	}
}
