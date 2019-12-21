
/* 
 * 클래스 이름 : ChickenHouse
 * 
 * 버전 정보 : 1
 * 
 * 날짜 : 2019.12.21
 * 
 * 저작권 주의
 */

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
	// final static List<Menu> menus = MenuRepository.menus();
	final static MenuRepository menus = new MenuRepository();

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
		tableNumber = InputView.inputTableNumber(tables, true);
		OutputView.printMenus(menus);
		MenuNumber = InputView.inputMenuNumber(menus);
		MenuCount = InputView.inputMenuCount();
		add(tableNumber, MenuNumber, MenuCount);
	}

	private static void add(int tableNumber, int menuNumber, int menuCount) {
		tables.getByNumber(tableNumber).add(menus.getByNumber(menuNumber), menuCount);
	}

	private static void pay() {
		int tableNumber;
		OutputView.printTables(tables);
		tableNumber = InputView.inputTableNumber(tables, false);
		calculate(InputView.inputPaymentMethod(tableNumber), TableRepository.getByNumber(tableNumber));
	}
	
	private static void calculate(int paymentMethod, Table table) {
		if(paymentMethod == 1) {
			creditCardCalculate(table);
			return;
		}
		cashCalculate(table);
	}

	private static void creditCardCalculate(Table table) {
		// TODO Auto-generated method stub
		
	}

	private static void cashCalculate(Table table) {
		// TODO Auto-generated method stub
		
	}
}
