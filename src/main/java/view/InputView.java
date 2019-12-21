package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int enterApplication() {
		try {
			System.out.println("##원하는 기능을 선택하세요");
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("1,2,3만 입력해주세요");
			return enterApplication();
		}
	}

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return scanner.nextInt();
	}

	public static int enterTableNumber() {
		try {
			System.out.println("##테이블을 선택하세요");
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("적절한 번호를 입력해주세요");
			return enterTableNumber();
		}
	}
	
	public static int enterNumOfMenu() {
		try {
			System.out.println("##등록할 메뉴를 선택하세요");
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("적절한 번호를 입력해주세요");
			return enterTableNumber();
		}
	}
	
	public static int enterAmountOfMenu() {
		try {
			System.out.println("##메뉴의 수량을 입력하세요");
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("적절한 숫자를 입력해주세요");
			return enterTableNumber();
		}
	}
	
	public static boolean enterCacheOrCard(int tableNum) {
		try {
			System.out.println("##" + tableNum + "번 테이블의 결제를 진행합니다\n"
					+ "##신용카드는 1번, 현금은 2번");
			return new CacheOrCard(Integer.parseInt(scanner.nextLine().trim())).isCache();
		} catch (IllegalArgumentException e) {
			System.out.println("1또는 2를 입력해주세요");
			return enterCacheOrCard(tableNum);
		}
	}
}
