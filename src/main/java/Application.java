import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	private static final int ORDER = 1;
	private static final int PAYMENT = 2;
	private static final int EXIT = 3;
	private static final List<Table> tables = TableRepository.tables();
	private static final List<Menu> menus = MenuRepository.menus();
	
	public static void main(String[] args) {
		int nowWork;
		do {
			nowWork = InputView.inputSelectWork();
			doWork(nowWork);

//			final List<Table> tables = TableRepository.tables();
//			OutputView.printTables(tables);
//
//			final int tableNumber = InputView.inputTableNumber();
//
//			OutputView.printMenus(menus);
		} while (nowWork != EXIT);
	}

	private static void doWork(int inputSelectWork) {
		if (inputSelectWork == ORDER) {
			doOrder();
		}
		if (inputSelectWork == PAYMENT) {
			doPayment();
		}
		if (inputSelectWork == EXIT) {
		}
	}


	private static void doOrder() {
		int nowTable;
		int nowMenu;
		int nowMenuCount;
		OutputView.printTables(tables);
		nowTable = InputView.inputSelectTable(tables);
		OutputView.printMenus(menus);
		nowMenu = InputView.inputSelectMenu(menus);
		nowMenuCount = InputView.inputSelectMenuCount(tables.get(nowTable));
	}
	private static void doPayment() {
		// TODO Auto-generated method stub
		
	}

}
