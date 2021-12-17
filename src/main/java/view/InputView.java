package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static String inputMainNumber() {
		System.out.println("## 원하는 기능을 선택하세요.");
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputTableNumber() {
		System.out.println("## 테이블을 선택하세요.");
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputMenuNumber() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputMenuCountNumber() {
		System.out.println("## 메뉴의 수량을 입력하세요.");
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}

	public static String inputPayNumber() {
		System.out.println("## 1번 테이블의 결제를 진행합니다.\n"
			+ "## 신용 카드는 1번, 현금은 2번");
		String answer = scanner.nextLine();
		OutputView.printBreak();
		return answer;
	}
}
