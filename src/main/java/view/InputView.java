package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMainMenu() {
        try {
            System.out.println("## 메인 화면");
            System.out.println("1 - 주문등록");
            System.out.println("2 - 결제하기");
            System.out.println("3 - 종료");
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            return inputMainMenu();
        }
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPaymentPolicy() {
        System.out.println("## 신용카드는 1번, 현금결제는 2");
        return scanner.nextInt();
    }
}
