package domain;

import view.InputView;
import view.OutputView;
import domain.Table;
import domain.TableRepository;
import domain.Menu;
import domain.MenuRepository;

import java.util.List;
import java.util.ArrayList;

public class Register {
	private static int orderMenu;
	private static int orderQuantity;
	
	public static void startOrder(List<Table> tables, List<Menu> menus) {
		OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        orderMenu = InputView.inputRegisterMenu();
        orderQuantity = InputView.inputOrderQuantity(tables);
        for (Table table : tables) {
        	if (table.getTableNumber() == tableNumber) {
        		table.registerMenuQuantity(orderMenu, orderQuantity);
        	}
        }
	}
}
