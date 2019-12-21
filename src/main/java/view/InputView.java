package view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_FUNCTION = "## 원하시는 기능을 선택하세요.";
    private static final String SELECT_MENU = "## 등록할 메뉴를 선택하세요.";
    private static final String SELECT_TABLE = "## 주문할 테이블을 선택하세요.";
    private static final String INPUT_COUNT = "## 메뉴의 수량을 입력하세요.";
    public static final String INVALID_TABLE_NUMBER = "유효하지 않는 테이블 번호입니다.";
    public static final String INVALID_MENU_NUMBER = "유효하지 않는 메뉴 번호입니다.";
    public static final String OVER_MAX_MENU_COUNT = "99개 이상으로 주문할 수 없습니다.";
    public static final String COUNT_MUST_OVER_ZERO = "주문하실 메뉴의 수량은 1이상이어야 합니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionNumber() {
        System.out.println(SELECT_FUNCTION);

        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println(SELECT_TABLE);

        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println(SELECT_MENU);

        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println(INPUT_COUNT);

        return scanner.nextInt();
    }

}
