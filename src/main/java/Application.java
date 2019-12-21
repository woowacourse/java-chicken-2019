import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		OutputView.mainDisplay();
		int command = InputView.inputTableNumber();

		while (true) {
			if (command == 1) {
				order();
				return;
			}
			if (command == 2) {
				pay();
				return;
			}
			if (command == 3) {
				return;
			}
		}

//		OutputView.printTables(tables);
//
//		final int tableNumber = InputView.inputTableNumber();
//
//		final List<Menu> menus = MenuRepository.menus();
//		OutputView.printMenus(menus);
	}

	private static void pay() {
		// TODO Auto-generated method stub

	}

	private static void order() {
		// TODO Auto-generated method stub

	}

}
