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
		OneOrTwoOrThree mainMenuNumber;

		do {
			mainMenuNumber = getMainMenuNumber();
		} while (!mainMenuNumber.isThree());

		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
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
}
