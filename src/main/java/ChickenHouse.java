import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenHouse {
	final static List<Table> tables = TableRepository.tables();

	public void execute() {
		while (true) {
			OutputView.mainDisplay();
			int command = InputView.inputCommand();
			if (command == 1) {
				order();
			}
			if (command == 2) {
				pay();
			}
			if (command == 3) {
				return;
			}
		}
	}

	private static void order() {
		OutputView.printTables(tables);

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
	}

	private static void pay() {

	}

}
