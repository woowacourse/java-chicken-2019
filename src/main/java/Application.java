import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;
import constant.FunctionNumber;
import constant.ProjectConstant;

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
		Menu tempMenu = menus.get(ProjectConstant.ZERO);
		for (Menu m : menus) {
			if (m.getNumber() == menuNumber) {
				return m;
			}
		}
		return tempMenu;
	}

	private static String inputOrderMenu() {
		String menu = ProjectConstant.EMPTY;

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
		if (!(length >= ProjectConstant.ONE && length <= ProjectConstant.TWO)) {
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
			if (!(c >= ProjectConstant.ASCII_ZERO && c <= ProjectConstant.ASCII_NINE)) {
				OutputView.printNotNumber();
				throw new RuntimeException();
			}
		}
	}

	private static String inputMenuCount() {
		String count = ProjectConstant.EMPTY;

		try {
			count = InputView.inputMenuCount();
			checkMenuCountValidation(count);
			return count;
		} catch (RuntimeException e) {
			count = inputMenuCount();
		}
		return count;
	}

	private static void checkMenuCountValidation(String count) {
		checkCountLength(count.length());
		checkStringIsNum(count);
		checkCountRange(Integer.parseInt(count));
	}

	private static void checkCountLength(int length) {
		if (!(length >= ProjectConstant.ONE && length <= ProjectConstant.TWO)) {
			OutputView.printMenuCountError();
			throw new RuntimeException();
		}
	}

	private static void checkCountRange(int count) {
		if (!(count >= ProjectConstant.ONE && count <= ProjectConstant.NINETYNINE)) {
			OutputView.printMenuCountError();
			throw new RuntimeException();
		}
	}

	private static int convertTableNumber(int number) {
		int convert = ProjectConstant.ZERO;
		if (number >= ProjectConstant.ONE && number <= ProjectConstant.THREE) {
			convert = number - ProjectConstant.ONE;
		}
		if (number >= ProjectConstant.FIVE && number <= ProjectConstant.SIX) {
			convert = number - ProjectConstant.TWO;
		}
		if (number == ProjectConstant.EIGHT) {
			convert = number - ProjectConstant.THREE;
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
