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
//			final List<Menu> menus = MenuRepository.menus();
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
		OutputView.printTables(tables);
		nowTable = InputView.inputSelectTable(tables);
	}
	private static void doPayment() {
		// TODO Auto-generated method stub
		
	}

}
