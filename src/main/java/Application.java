import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;
import Controller.SelectControl;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
	final List<Table> tables = TableRepository.tables();
	final List<Menu> menus = MenuRepository.menus();
	while (run(tables, menus)) {
	}
    }

    public static boolean run(List<Table> tables, List<Menu> menus) {
	OutputView.printMainScreen();
	final int functionNumber = InputView.inputFuction();
	if (functionNumber == 3) {
	    return QuitFunction();
	}
	OutputView.printTables(tables);
	final int tableNumber = InputView.inputTableNumber(tables);
	OutputView.printMenus(menus);
	if (functionNumber == 1) {
	    OrderFunction(tables, menus, tableNumber);
	}
	if (functionNumber == 2) {
	    PayFunction(tables,menus,tableNumber);
	}
	return true;
    }

    public static void OrderFunction(List<Table> tables, List<Menu> menus, int tableNumber) {
	int menuNumber = InputView.inputMenu(menus);
	int menuAmount = InputView.inputMenuAmount(tables.get(tableNumber));
	if (menuNumber<=6) {
	    tables.get(tableNumber).setChickenPrice(menus.get(menuNumber-1).getNumber(),menuAmount,menus.get(menuNumber-1).getPrice());
	    return;
	}
	tables.get(tableNumber).setDrinkPrice(menus.get(menuNumber-15).getNumber(),menuAmount,menus.get(menuNumber-15).getPrice());
    }

    public static void PayFunction(List<Table> tables, List<Menu> menus, int tableNumber) {
	OutputView.printOrderList(tables.get(tableNumber),menus);
    }

    public static boolean QuitFunction() {
	return false;
    }
}
