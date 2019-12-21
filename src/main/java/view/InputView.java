package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenu() {
        System.out.println("등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputQuantity() {
        System.out.println("메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
}
