package view;

import java.util.Scanner;

public class InputView {
    // private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner("1\n1\n1\n11\n2\n1\n1\n3\n");

    public static int inputMain() {
        OutputView.printFeatures();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPayMethod(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.\n"
            + "## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
