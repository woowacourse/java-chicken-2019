import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;
import constant.FunctionNumber;
import constant.ProjectConstant;
import constant.PaymentMethodNumber;

import java.util.List;

public class Application {
	// TODO 구현 진행
	private final static List<Table> tables = TableRepository.tables();
	private final static List<Menu> menus = MenuRepository.menus();
	private static int tableNumber;

	/**
	 * 포스기를 실행하는 함수.
	 */
	private void run() {
		InputView.showMainView();
		String functionNumber = InputView.inputFunctionNumber();
		if (selectFunction(Integer.parseInt(functionNumber))) {
			run();
		}
	}
	
	/**
	 * 입력된 포스기 값에 따라서 주문, 결제, 종료를 실행한다.
	 * @param number 사용자의 입력값
	 * @return 포스기 동작 여부
	 */
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
	
	/**
	 * 주문을 진행한다.
	 */
	private static void doOrder() {
		System.out.println();
		OutputView.printTables(tables);
		tableNumber = convertTableNumber(Integer.parseInt(InputView.inputTableNumber()));
		OutputView.printMenus(menus);
		int menuNumber = Integer.parseInt(inputOrderMenu());
		Menu myMenu = findMenu(menuNumber);
		int menuCount = Integer.parseInt(inputMenuCount(myMenu));
		tables.get(tableNumber).addMenu(myMenu, menuCount);
	}
	
	/**
	 * 사용자가 입력한 메뉴가 어떤 메뉴인지 찾는다.
	 */
	private static Menu findMenu(int menuNumber) {
		Menu tempMenu = menus.get(ProjectConstant.ZERO);
		for (Menu m : menus) {
			if (m.getNumber() == menuNumber) {
				return m;
			}
		}
		return tempMenu;
	}
	
	/**
	 * 입력한 메뉴가 유효한 메뉴인지 검사한다.
	 * @return 유효한 메뉴 번호
	 */
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
	
	/**
	 * 사용자가 입력한 메뉴 수량이 유효한지 검사한다.
	 * @return 유요한 메뉴 수량
	 */
	private static String inputMenuCount(Menu menu) {
		String count = ProjectConstant.EMPTY;

		try {
			count = InputView.inputMenuCount();
			checkMenuCountValidation(count, menu);
			return count;
		} catch (RuntimeException e) {
			count = inputMenuCount(menu);
		}
		return count;
	}
	
	private static void checkMenuCountValidation(String count, Menu menu) {
		checkCountLength(count.length());
		checkStringIsNum(count);
		checkCountRange(Integer.parseInt(count));
		checkTableMenuSum(Integer.parseInt(count), menu);
	}
	
	private static void checkTableMenuSum(int count, Menu menu) {
		if (tables.get(tableNumber).hasSameMenu(menu) && 
				count + tables.get(tableNumber).getSameMenuCount(menu) > 99) {
			OutputView.printOverMax();
			throw new RuntimeException();
		}
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
	
	/**
	 * 사용자가 입력한 테이블 숫자는 컴퓨터에서 사용하는 배열의 인덱스와 다르므로
	 * 인덱스를 수정해준다.
	 * @param number 사용자가 입력한 숫자
	 * @return 배열의 인덱스
	 */
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
	
	/**
	 * 결제 기능 함수
	 */
	public static void pay() {
		System.out.println();
		OutputView.printTables(tables);
		tableNumber = convertTableNumber(Integer.parseInt(InputView.inputTableNumber()));
		if (!tableHasOrder()) {
			OutputView.printSelectOrderedTable();
			pay();
			return;
		}
		doPay();
	}
	
	/**
	 * 주문이 있는 테이블인지 확인한다
	 * @return 주문이 있는 테이블인지 확인
	 */
	private static boolean tableHasOrder() {
		if (tables.get(tableNumber).getMenuListSize() == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 결제를 완료하는 함수
	 */
	private static void doPay() {
		tables.get(tableNumber).printMenu();
		System.out.println("## " + tables.get(tableNumber).toString() + "번 테이블의 결제를 진행합니다.");
		int paymentMethod = Integer.parseInt(InputView.inputPaymentMethod());
		double amount = setAmount(paymentMethod);
		OutputView.printAmount(amount);
	}
	
	/**
	 * 최종 결제 금액을 계산한다.
	 * @param paymentMethod 결제 수단
	 * @return 최종 결제 금액
	 */
	private static double setAmount(int paymentMethod) {
		double amount = 0d;

		if (paymentMethod == Integer.parseInt(PaymentMethodNumber.One.getValue())) {
			amount = tables.get(tableNumber).getAllMenuSum();
		}
		if (paymentMethod == Integer.parseInt(PaymentMethodNumber.Two.getValue())) {
			amount = tables.get(tableNumber).discountForCash();
		}
		tables.get(tableNumber).clear();
		return amount;
	}

	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
