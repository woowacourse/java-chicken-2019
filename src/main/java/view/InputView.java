package view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int[] validTableNumbers = {1, 2, 3, 5, 6, 8};
    private static final int[] validFunctionNumbers = {1, 2, 3};
    private static final int[] validPaymentTypeNumbers = {1, 2};
    private static final int[] validMenuNumbers = {1, 2, 3, 4, 5, 6, 21, 22};

    public static boolean checkInRange(int[] range, int input) {
        for (int i : range) {
            if (i == input) return true;
        }
        return false;
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        int input = scanner.nextInt();
        if (!checkInRange(validTableNumbers, input)) {
            throw new IllegalArgumentException("유효한 테이블 번호가 아닙니다. 1, 2, 3, 5, 6, 8 의 테이블 번호를 입력하세요.");
        }
        return input;
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        int input = scanner.nextInt();
        if (!checkInRange(validMenuNumbers, input)) {
            throw new IllegalArgumentException("유효한 메뉴 번호가 아닙니다. 확인 후 다시 입력하세요.");
        }
        return input;
    }

    public static int inputAmountNumber() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        int input = scanner.nextInt();
        if (input <= 0 || input >= 100) {
            throw new IllegalArgumentException("가능한 주문의 수량은 1개 이상 99개 이하입니다.");
        }
        return input;
    }

    public static int inputMainFunctionNumber() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        int input = scanner.nextInt();
        if (!checkInRange(validFunctionNumbers, input)) {
            throw new IllegalArgumentException("유효한 기능 번호가 아닙니다. 1, 2, 3 중 하나를 입력하세요.");
        }
        return input;
    }

    public static int inputCardOrCash(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용카드는 1번, 현금은 2번");
        int input = scanner.nextInt();
        if (!checkInRange(validPaymentTypeNumbers, input)) {
            throw new IllegalArgumentException("유효한 결제 타입이 아닙니다. 신용카드는 1번, 현금은 2번입니다.");
        }
        return input;
    }
}
