package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPosMenu() {
        println("## 메인화면\n" +
                "1 - 주문등록\n" +
                "2 - 결제하기\n" +
                "3 - 프로그램 종료");
        println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    private static void println(String message) {
        System.out.println("\n" + message);
    }
}
