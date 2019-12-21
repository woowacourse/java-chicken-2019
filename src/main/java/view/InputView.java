package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_FUNCTION_NUMBER_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_MENU_NUMBER_MESSAGE = "## 등록할 메뉴 선택하세요.";
    private static final String INPUT_MENU_AMOUNT_MESSAGE = "## 메뉴의 수량을 입력하세요.";
	private static final String PAYMENT_MESSAGE = "번 테이블의 결제를 진행합니다.";
	private static final String INPUT_PAYMENT_WAY_NUMBER_MESSAGE = "## 신용 카드는 1번, 현금은 2번";

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputFunctionNumber() {
        System.out.println(INPUT_FUNCTION_NUMBER_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputMenuNumber() {
        System.out.println(INPUT_MENU_NUMBER_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
    }

    public static int inputMenuAmount() {
        System.out.println(INPUT_MENU_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputPaymentWayNumber(int tableNumber) {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("## ").append(tableNumber);
    	stringBuilder.append(PAYMENT_MESSAGE);
    	System.out.println(stringBuilder.toString());
    	System.out.println(INPUT_PAYMENT_WAY_NUMBER_MESSAGE);
    	return Integer.parseInt(scanner.nextLine());
	}
}
