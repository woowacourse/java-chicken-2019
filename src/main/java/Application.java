import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		while (true) {
			OutputView.mainDisplay();
			int command = InputView.inputTableNumber();
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
