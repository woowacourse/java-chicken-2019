
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
import java.util.Map;

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
		boolean finished = false;
		while (!finished) {
			try {
				finished = whileLoop();
			} catch (Exception e) {
				System.err.println(e);
				System.out.println();
			}
		}
	}
	
	private static boolean whileLoop() {
			OutputView.mainDisplay();
			int command = InputView.inputCommand();
			if (command == 1) {
				order();
				return false;
			}
			if (command == 2) {
				pay();
				return false;
			}
			if (command == 3) {
				return true;
			}
			return true;
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
		OutputView.printAllMenuesOfTable(tables.getByNumber(tableNumber));
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
		int chickenCount = 0;
		for (Map.Entry<Menu, Integer> menu : table.getMenus.entrySet()) {
			if(menu.getKey().getCategory() == "치킨") {
				chickenCount += menu.getValue();
			}
		}

		
	}

	private static void cashCalculate(Table table) {
		// TODO Auto-generated method stub
		
	}
}
