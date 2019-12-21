package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int PROCESS_SELECTION_RANGE = 3;

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
