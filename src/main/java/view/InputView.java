package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int PROCESS_SELECTION_RANGE = 3;
	private static final int MAX_ORDER_NUMBER = 99;

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		try {
			int tableNumber = validateNumber(scanner.nextLine().trim());
			return tableNumber;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputTableNumber();
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
