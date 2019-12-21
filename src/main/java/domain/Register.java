package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

public class Register {
	private static int orderMenu;
	private static int orderQuantity;

	public static void startOrder(List<Table> tables, List<Menu> menus) {
		final int tableNumber = InputView.inputTableNumber();
		OutputView.printMenus(menus);
		orderMenu = InputView.inputRegisterMenu();
		orderQuantity = InputView.inputOrderQuantity(tables, tableNumber);
		for (Table table : tables) {
			if (table.getTableNumber() == tableNumber) {
				table.registerMenuQuantity(orderMenu, orderQuantity, tableNumber);
			}
		}
	}
}
