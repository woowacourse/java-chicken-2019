package view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return scanner.nextInt();
	}

	public static int inputMenu() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		return scanner.nextInt();
	}

	public static int inputQuantity() {
		System.out.println("## 메뉴의 수량을 선택하세요.");
		return scanner.nextInt();
	}

	public static void mainView() {
		System.out.println("## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n");
	}

	public static int mainViewInput() {
		System.out.println("## 원하는 기능을 선택하세요");
		return scanner.nextInt();
	}

	public static int validMainViewInput() {
		int userInput = 0;
		try {
			userInput = mainViewInput();
			if (userInput != 1 && userInput != 2 && userInput != 3) {
				throw new Exception();
			}
		} catch (Exception e) {
			scanner = new Scanner(System.in);
			System.out.println("[잘못된 입력] 1, 2, 3 중 하나를 입력하세요");
			userInput = validMainViewInput(); // 오류시 재귀
		}
		return userInput;
	}

	public static int choosePaymentMethod() {
		System.out.println("## 신용카드는 1번, 현금은 2번");
		return scanner.nextInt();
	}
}
