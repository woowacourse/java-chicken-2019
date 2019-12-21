package view;

import java.util.Scanner;

import domain.MenuRepository;
import domain.TableRepository;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int PROCESS_SELECTION_RANGE = 3;
	private static final int MAX_ORDER_NUMBER = 99;
	private static final int CREDIT_CARD = 1;
	private static final int CASH = 2;
	private static final String SELECT_TABLE_TO_ORDER = "## 주문할 테이블을 선택하세요.";
	private static final String SELECT_TABLE_TO_PAY = "## 결제할 테이블을 선택하세요.";
	private static final String SELECT_MAIN_PROCESS = "원하는 기능을 선택하세요";
	private static final String SELECT_MENU = "## 등록할 메뉴를 선택하세요.";
	private static final String SELECT_AMOUNT_OF_MENU = "## 메뉴의 수량을 입력하세요.";
	private static final String SELECT_PAYMENT_TYPE = "신용카드는 1번, 현금은 2";
	private static final String NO_MENU_ERROR = "메뉴판에 없는 메뉴입니다.";
	private static final String NO_TABLE_ERROR = "유효하지 않은 테이블 번호 입니다.";
	private static final String INVALID_INPUT_ERROR = "올바른 입력값이 아닙니다.";
	private static final String MENU_MAX_AMOUNT_ERROR = "한 메뉴의 최대 수량은 99개 입니다";
	private static final String OUT_OF_LIST_ERROR = "선택지에 없는 값입니다.";

	public static int inputTableNumber() {
		System.out.println(SELECT_TABLE_TO_ORDER);
		try {
			int tableNumber = validateNumber(scanner.nextLine().trim());
			validateTableNumber(tableNumber);
			return tableNumber;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputTableNumber();
		}
	}

	public static int inputTableNumberToPay() {
		System.out.println(SELECT_TABLE_TO_PAY);
		try {
			int tableNumber = validateNumber(scanner.nextLine().trim());
			validateTableNumber(tableNumber);
			return tableNumber;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputTableNumberToPay();
		}
	}

	public static int inputMainProcess() {
		System.out.println(SELECT_MAIN_PROCESS);
		try {
			int process = validateNumber(scanner.nextLine().trim());
			validateRangeOfProcess(process);
			return process;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMainProcess();
		}
	}

	public static int inputOrderMenu() {
		System.out.println(SELECT_MENU);
		try {
			int orderMenu = validateNumber(scanner.nextLine().trim());
			validateRangeOfMenus(orderMenu);
			return orderMenu;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputOrderMenu();
		}
	}

	public static int inputNumberOfMenu() {
		System.out.println(SELECT_AMOUNT_OF_MENU);
		try {
			int numberOfMenu = validateNumber(scanner.nextLine().trim());
			validateMaxOrderNumber(numberOfMenu);
			return numberOfMenu;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputNumberOfMenu();
		}
	}

	public static int inputPaymentType() {
		System.out.println(SELECT_PAYMENT_TYPE);
		try {
			int paymentType = validateNumber(scanner.nextLine().trim());
			validatePaymentType(paymentType);
			return paymentType;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPaymentType();
		}
	}

	private static void validateRangeOfMenus(int menuNumber) {
		if (!MenuRepository.isAvailableMenu(menuNumber)) {
			throw new IllegalArgumentException(NO_MENU_ERROR);
		}
	}

	private static void validateTableNumber(int tableNumber) {
		if (!TableRepository.isAvailableTable(tableNumber)) {
			throw new IllegalArgumentException(NO_TABLE_ERROR);
		}
	}

	private static void validatePaymentType(int paymentType) {
		if (paymentType != CREDIT_CARD && paymentType != CASH) {
			throw new IllegalArgumentException(INVALID_INPUT_ERROR);
		}
	}

	private static void validateMaxOrderNumber(int menu) {
		if (menu > MAX_ORDER_NUMBER) {
			throw new IllegalArgumentException(MENU_MAX_AMOUNT_ERROR);
		}
	}

	private static void validateRangeOfProcess(int process) {
		if (process > PROCESS_SELECTION_RANGE) {
			throw new IllegalArgumentException(OUT_OF_LIST_ERROR);
		}
	}

	private static int validateNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			isPositiveNumber(number);
			return number;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(INVALID_INPUT_ERROR);
		}
	}

	private static void isPositiveNumber(int input) {
		if (input <= 0) {
			throw new IllegalArgumentException();
		}
	}
}
