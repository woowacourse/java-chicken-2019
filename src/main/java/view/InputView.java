package view;

import java.util.Scanner;

import static util.InputUtil.inputInt;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputNextStep() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return inputInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return inputInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 주문할 메뉴를 선택하세요.");
        return inputInt();
    }

    public static int inputMenuMount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return inputInt();
    }

    public static int inputPaymentMethod(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return inputInt();
    }
}
