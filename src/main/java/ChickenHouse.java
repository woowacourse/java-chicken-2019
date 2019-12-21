import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenHouse {
	// final static List<Table> tables = TableRepository.tables();
	final static TableRepository tables = new TableRepository();
	final static List<Menu> menus = MenuRepository.menus();

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
		int tableNumber;
		int MenuNumber;
		int MenuCount;
		OutputView.printTables(tables);
		tableNumber = InputView.inputTableNumber(tables);
		OutputView.printMenus(menus);
		MenuNumber = InputView.inputMenuNumber(menus);
		MenuCount = InputView.inputMenuCount();
		add(tableNumber, MenuNumber, MenuCount);
	}

	private static void add(int tableNumber, int menuNumber, int menuCount) {
		tables.getByNumber(tableNumber).add(menuNumber, menuCount);

	}

	private static void pay() {

	}

}
