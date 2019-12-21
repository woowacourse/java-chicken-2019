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
	    PayFunction();
	}
	return true;
    }

    public static void OrderFunction(List<Table> tables, List<Menu> menus, int tableNumber) {
	int menuNumber = InputView.inputMenu(menus);
	int menuAmount = InputView.inputMenuAmount(tables.get(tableNumber));
	if (menus.get(menuNumber).getCategoryName().equals("치킨")) {
	    tables.get(tableNumber).setChickenPrice(menuAmount,menus.get(menuNumber).getPrice());
	    return;
	}
	tables.get(tableNumber).setDrinkPrice(menuAmount,menus.get(menuNumber).getPrice());
    }

    public static void PayFunction() {
    }

    public static boolean QuitFunction() {
	return false;
    }
}
