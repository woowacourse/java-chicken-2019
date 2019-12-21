package view;

import java.util.Scanner;

public class InputView {
	private static final int PAYMENT_CREDITCARD = 1;
	private static final int PAYMENT_CASH = 2;
	
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputTableNumber() throws Exception {
		System.out.println("## 테이블을 선택하세요.");
		int tableNumber = 0;
		try {
			tableNumber = scanner.nextInt();
		} catch (Exception e) {
			throw new Exception("잘못된 입력입니다.");
		}
		return tableNumber;
	}

	public static int inputMainMenuNumber() throws Exception {
		System.out.println("## 원하는 기능을 선택하세요.");
		int menuNumber = 0;
		try {
			menuNumber = scanner.nextInt();
		} catch (Exception e) {
			throw new Exception("잘못된 입력입니다.");
		}
		return menuNumber;
	}

	public static int inputPaymentMenuNumber() throws Exception {
		System.out.println("## 신용카드는 1번, 현금은 2번");
		int menuNumber = 0;
		try {
			menuNumber = scanner.nextInt();
			if(menuNumber != PAYMENT_CASH && menuNumber != PAYMENT_CREDITCARD) {
				throw new Exception("잘못된 입력입니다.");
			}
		} catch (Exception e) {
			throw new Exception("잘못된 입력입니다.");
		}
		return menuNumber;
	}

	public static int inputMenuSelect() throws Exception {
		System.out.println("## 등록할 메뉴를 선택하세요");
		int menuNumber = 0;
		try {
			menuNumber = scanner.nextInt();
		} catch (Exception e) {
			throw new Exception("잘못된 입력입니다.");
		}
		return menuNumber;
	}

	public static int inputMenuCount() throws Exception {
		System.out.println("## 메뉴의 수량을 입력하세요");
		int menuCount = 0;
		try {
			menuCount = scanner.nextInt();
		} catch (Exception e) {
			throw new Exception("잘못된 입력입니다.");
		}
		return menuCount;
	}
}
