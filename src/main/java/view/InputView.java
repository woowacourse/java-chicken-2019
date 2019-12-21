package view;

import domain.model.PayType;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_OPTION_MSG = "## 원하는 기능을 입력하세요.";
    private static final String INPUT_TABLE_MSG = "## 테이블을 선택하세요.";
    private static final String INPUT_MENU_MSG = "## 등록할 메뉴를 선택하세요.";
    private static final String INPUT_COUNT_MSG = "## 메뉴의 수량을 선택하세요.";
    private static final String TITLE_PAY_TYPE = "## 결제 수단";
    private static final String EXIT_MSG = "## 프로그램을 종료합니다.";

    public static String inputTableNumber() {
        System.out.println(INPUT_TABLE_MSG);
        return scanner.nextLine();
    }

    public static String inputMainOption() {
        System.out.println(INPUT_OPTION_MSG);
        return scanner.nextLine();
    }

    public static String inputMenu() {
        System.out.println(INPUT_MENU_MSG);
        return scanner.nextLine();
    }

    public static String inputCount() {
        System.out.println(INPUT_COUNT_MSG);
        return scanner.nextLine();
    }

    public static String inputPayType(PayType[] payTypes) {
        System.out.println(TITLE_PAY_TYPE);
        for (PayType payType : payTypes) {
            System.out.println(payType.toString());
        }
        return scanner.nextLine();
    }

    public static void closeView() {
        System.out.println(EXIT_MSG);
        scanner.close();
    }
}
