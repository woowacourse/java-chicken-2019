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

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
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
		System.out.println("## 결제할 테이블을 선택하세요.");
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
		System.out.println("원하는 기능을 선택하세요");
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
		System.out.println("## 등록할 메뉴를 선택하세요.");
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
		System.out.println("## 메뉴의 수량을 입력하세요.");
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
		System.out.println("신용카드는 1번, 현금은 2");
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
			throw new IllegalArgumentException("메뉴판에 없는 메뉴입니다.");
		}
	}

	private static void validateTableNumber(int tableNumber) {
		if (!TableRepository.isAvailableTable(tableNumber)) {
			throw new IllegalArgumentException("유효하지 않은 테이블 번호 입니다.");
		}
	}

	private static void validatePaymentType(int paymentType) {
		if (paymentType != CREDIT_CARD && paymentType != CASH) {
			throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
		}
	}

	private static void validateMaxOrderNumber(int menu) {
		if (menu > MAX_ORDER_NUMBER) {
			throw new IllegalArgumentException("한 메뉴의 최대 수량은 99개 입니다");
		}
	}

	private static void validateRangeOfProcess(int process) {
		if (process > PROCESS_SELECTION_RANGE) {
			throw new IllegalArgumentException("선택지에 없는 값입니다.");
		}
	}

	private static int validateNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			isPositiveNumber(number);
			return number;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
		}
	}

	private static void isPositiveNumber(int input) {
		if (input <= 0) {
			throw new IllegalArgumentException();
		}
	}
}
