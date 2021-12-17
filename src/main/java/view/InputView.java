package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	public static final String PRINT_MAIN = "## 원하는 기능을 선택하세요.";
	public static final String PRINT_TABLE = "## 테이블을 선택하세요.";
	public static final String PRINT_MENU = "## 등록할 메뉴를 선택하세요.";
	public static final String PRINT_MENU_COUNT = "## 메뉴의 수량을 입력하세요.";
	public static final String PRINT_PAY = "## 1번 테이블의 결제를 진행합니다.\n"
		+ "## 신용 카드는 1번, 현금은 2번";

	public static String inputMainNumber() {
		System.out.println(PRINT_MAIN);
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputTableNumber() {
		System.out.println(PRINT_TABLE);
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputMenuNumber() {
		System.out.println(PRINT_MENU);
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputMenuCountNumber() {
		System.out.println(PRINT_MENU_COUNT);
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputPayNumber() {
		System.out.println(PRINT_PAY);
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}
}
