import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;
import constant.FunctionNumber;

import java.util.List;

public class Application {
	// TODO 구현 진행
	private final static List<Table> tables = TableRepository.tables();
	private final static List<Menu> menus = MenuRepository.menus();
	private static int tableNumber;

	private void run() {
		InputView.showMainView();
		String functionNumber = InputView.inputFunctionNumber();
		if (selectFunction(Integer.parseInt(functionNumber))) {
			run();
		}
	}

	public static boolean selectFunction(int number) {
		if (number == Integer.parseInt(FunctionNumber.Three.getValue())) {
			return false;
		}
		if (number == Integer.parseInt(FunctionNumber.One.getValue())) {
			doOrder();
		}
		if (number == Integer.parseInt(FunctionNumber.Two.getValue())) {
			pay();
		}
		return true;
	}

	private static void doOrder() {
		System.out.println();
		OutputView.printTables(tables);
		tableNumber = convertTableNumber(Integer.parseInt(InputView.inputTableNumber()));
		OutputView.printMenus(menus);
		int menuNumber = Integer.parseInt(inputOrderMenu());
		Menu myMenu = findMenu(menuNumber);
		int menuCount = Integer.parseInt(inputMenuCount());
		tables.get(tableNumber).addMenu(myMenu, menuCount);
	}

	private static Menu findMenu(int menuNumber) {
		Menu tempMenu = menus.get(0);
		for (Menu m : menus) {
			if (m.getNumber() == menuNumber) {
				return m;
			}
		}
		return tempMenu;
	}

	private static String inputOrderMenu() {
		String menu = "";

		try {
			menu = InputView.inputMenuNumber();
			checkOrderMenuValidation(menu);
			return menu;
		} catch (RuntimeException e) {
			menu = inputOrderMenu();
		}
		return menu;
	}

	private static void checkOrderMenuValidation(String menu) {
		checkOrderMenuLength(menu.length());
		checkStringIsNum(menu);
		checkOrderMenuNumber(menu);
	}

	private static void checkOrderMenuLength(int length) {
		if (!(length >= 1 && length <= 2)) {
			OutputView.printOrderMenuError();
			throw new RuntimeException();
		}
	}

	private static void checkOrderMenuNumber(String menu) {
		boolean check = false;

		for (Menu m : menus) {
			if (check == true) {
				break;
			}
			check = m.checkIsMenuNumber(menu);
		}
		if (check == false) {
			OutputView.printOrderMenuError();
			throw new RuntimeException();
		}
	}

	private static void checkStringIsNum(String string) {
		for (char c : string.toCharArray()) {
			if (!(c >= 48 && c <= 57)) {
				OutputView.printNotNumber();
				throw new RuntimeException();
			}
		}
	}

	private static String inputMenuCount() {
		String count = "";

		try {
			count = InputView.inputMenuCount();
			checkMenuCountValidation(count);
		} catch (RuntimeException e) {

		}
		return count;
	}

	private static void checkMenuCountValidation(String count) {
		checkCountLength(count.length());
		checkStringIsNum(count);
		checkCountRange(Integer.parseInt(count));
	}

	private static void checkCountLength(int length) {
		if (!(length >= 1 && length <= 2)) {
			OutputView.printMenuCountError();
			throw new RuntimeException();
		}
	}

	private static void checkCountRange(int count) {
		if (!(count >= 1 && count <= 99)) {
			OutputView.printMenuCountError();
			throw new RuntimeException();
		}
	}

	private static int convertTableNumber(int number) {
		int convert = 0;
		if (number >= 1 && number <= 3) {
			convert = number - 1;
		}
		if (number >= 5 && number <= 6) {
			convert = number - 2;
		}
		if (number == 8) {
			convert = number - 3;
		}
		return convert;
	}

	public static void pay() {

	}

	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
