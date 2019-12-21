package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINE = "\n";

    public static int inputMainNumber() {
        System.out.println(LINE + "## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println(LINE + "## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println(LINE + "## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }
}
