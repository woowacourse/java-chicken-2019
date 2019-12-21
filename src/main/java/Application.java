import static view.InputView.*;
import static view.OutputView.*;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	private static final int ORDER_FUNCTION = 1;
	private static final int PAY_FUNCTION = 2;
	private static final int EXIT_PROGRAM = 3;

	// TODO 구현 진행
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		final List<Menu> menus = MenuRepository.menus();

		runPos(tables, menus);
	}

	private static void runPos(List<Table> tables, List<Menu> menus) {
		OutputView.printMain();
		int functionNumber = InputView.inputFunctionNumber();
		if (functionNumber == EXIT_PROGRAM) {
			OutputView.printProgramExit();
			return;
		}

		runFunction(functionNumber, tables, menus);
		runPos(tables, menus);
	}

	private static void runFunction(int functionNumber, List<Table> tables, List<Menu> menus) {
		OutputView.printTables(tables);
		int tableNumber = InputView.inputTableNumber();
		if (functionNumber == ORDER_FUNCTION) {
			order(tableNumber, tables, menus);
			return;
		}

		pay(tableNumber, tables, menus);
	}

	private static void pay(int tableNumber, List<Table> tables, List<Menu> menus) {
		try {
			Table selectTable = findTable(tableNumber, tables);
			OutputView.printBill(selectTable);
			OutputView.printPayMessage(tableNumber);
			InputView.inputCardOrCash();
		} catch (IllegalArgumentException exception) {
			pay(tableNumber, tables, menus);
		}
	}

	private static void order(int tableNumber, List<Table> tables, List<Menu> menus) {
		OutputView.printMenus(menus);
		try {
			int menuNumber = InputView.inputMenuNumber();
			int menuCount = InputView.inputMenuCount();
			Table selectTable = findTable(tableNumber, tables);

			selectTable.addOrder(new Order(menuNumber, menuCount, menus));
		} catch (IllegalArgumentException exception) {
			order(tableNumber, tables, menus);
		}
	}

	private static Table findTable(int tableNumber, List<Table> tables) {
		for (Table table : tables) {
			if (table.isThisTable(tableNumber)) {
				return table;
			}
		}

		throw new IllegalArgumentException(INVALID_TABLE_NUMBER);
	}
}
