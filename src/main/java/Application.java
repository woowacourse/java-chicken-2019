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
	final List<Menu> menus = MenuRepository.menus();
	while (run(tables, menus)) {
	}
    }

    public static boolean run(List<Table> tables, List<Menu> menus) {
	OutputView.printMainScreen();
	final int functionNumber = InputView.inputFuction();
	if (functionNumber == 3) {
	    return QuitFunction(tables,menus);
	}
	OutputView.printTables(tables);
	int tableNumber = InputView.inputTableNumber(tables);
	tableNumber=setTableNumberIndex(tableNumber);
	if (functionNumber == 1) {
	    OrderFunction(tables, menus, tableNumber);
	}
	if (functionNumber == 2) {
	    PayFunction(tables,menus,tableNumber);
	}
	return true;
    }

    public static int setTableNumberIndex(int t) {
	if (t==5) {
	    return 4;
	}
	if(t==6) {
	    return 5;
	}
	if(t==8) {
	    return 6;
	}
	return t;
    }
    
    public static void OrderFunction(List<Table> tables, List<Menu> menus, int tableNumber) {
	OutputView.printMenus(menus);
	int menuNumber = InputView.inputMenu(menus);
	int menuAmount = InputView.inputMenuAmount(tables.get(tableNumber-1));
	if (menuNumber<=6) {
	    tables.get(tableNumber-1).setChickenPrice(menus.get(menuNumber-1).getNumber(),menuAmount,menus.get(menuNumber-1).getPrice());
	    return;
	}
	tables.get(tableNumber-1).setDrinkPrice(menus.get(menuNumber-15).getNumber(),menuAmount,menus.get(menuNumber-15).getPrice());
    }

    public static void PayFunction(List<Table> tables, List<Menu> menus, int tableNumber) {
	OutputView.printOrderList(tables.get(tableNumber-1),menus);
	final int pay=InputView.inputPay(tables.get(tableNumber-1).getNumber());
	OutputView.printPrice(tables.get(tableNumber-1),menus,pay);
    }

    public static boolean QuitFunction(List<Table> tables, List<Menu> menus) {
	for(int i=0;i<tables.size();i++) {
	    if (tables.get(i).getOrderd()) {
		int pay= InputView.inputPay(tables.get(i).getNumber());
		OutputView.printPrice(tables.get(i),menus,pay);
	    }
	}
	return false;
    }
}
