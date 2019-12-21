package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return scanner.nextInt();
	}

	public static int inputMainProcess() {
		System.out.println("원하는 기능을 선택하세요");
		try {
			int process = validateNumber(scanner.nextLine().trim());
			return process;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMainProcess();
		}
	}

	private static int validateNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			isPositiveNumber(number);
			return number;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}

	private static void isPositiveNumber(int input) {
		if (input <= 0) {
			throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
		}
	}
}
