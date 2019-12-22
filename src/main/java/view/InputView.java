package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionNumber() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("\n## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("\n## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputNumberOfMenu() {
        System.out.println("\n## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputTypeOfPayment() {
        System.out.println("\n## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
