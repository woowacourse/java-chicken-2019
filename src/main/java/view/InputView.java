package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMainMenuNumber() {
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println();
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println();
        System.out.println("## 등록할 메뉴를 선택하세요");
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println();
        System.out.println("## 메뉴의 수량을 입력하세요");
        return scanner.nextInt();
    }

    public static int inputPaymentWay() {
        System.out.println();
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }

}
