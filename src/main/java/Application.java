import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import util.InputUtil;
import util.OneOrTwoOrThree;
import util.OutputUtil;
import util.TotalOrder;
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
			int tableNumber = getTableNumber(tables, mainMenuNumber.getValue());

			if (mainMenuNumber.isOne()) {
				orderByTable(tableNumber);
			}
			if (mainMenuNumber.isTwo()) {
				payByTable(tableNumber);
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

	private static int getTableNumber(List<Table> tables, int mainMenuNumber) {
		int tableNumber;

		try {
			OutputView.printTables(tables);
			tableNumber = InputUtil.checkTableNumber(InputView.inputTableNumber(), mainMenuNumber).getValue();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return getTableNumber(tables, mainMenuNumber);
		}
		return tableNumber;
	}

	private static void orderByTable(int tableNumber) {
		final List<Menu> menus = MenuRepository.menus();
		int menuNumber = getMenuNumber(menus);
		int menuCount = getMenuCount(menuNumber);

		TableRepository.tables().stream()
			.filter(t -> t.getNumber() == tableNumber)
			.findFirst()
			.get().addMenus(menuNumber, menuCount);
	}

	private static int getMenuNumber(List<Menu> menus) {
		int menuNumber;

		try {
			OutputView.printMenus(menus);
			menuNumber = InputUtil.checkMenuNumber(InputView.inputMenuNumber()).getValue();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return getMenuNumber(menus);
		}
		return menuNumber;
	}

	private static int getMenuCount(int menuNumber) {
		int menuCount;

		try {
			menuCount = InputUtil.checkMenuCount(InputView.inputMenuCount()).getValue();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return getMenuCount(menuNumber);
		}
		return menuCount;
	}

	private static void payByTable(int tableNumber) {
		List<Menu> orderedMenus = TableRepository.tables().stream()
			.filter(t -> t.getNumber() == tableNumber)
			.findFirst().get().getMenus();
		TotalOrder totalOrder = OutputUtil.getOrderedList(orderedMenus);
		OutputView.printOrderedList(totalOrder.toString());
	}
}
