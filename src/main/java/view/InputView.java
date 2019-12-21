package view;

import java.util.Scanner;

public class InputView {
    private static final String NEWLINE = "\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println(NEWLINE + "## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenu() {
        System.out.println(NEWLINE + "원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputOrder() {
        System.out.println(NEWLINE + "등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputCount() {
        System.out.println(NEWLINE + "메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
}
