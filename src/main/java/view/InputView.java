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
        println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuAmount() {
        println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPayment(int tableNumber) {
        println("## " + tableNumber +"번 테이블의 결제를 진행합니다.\n" +
                "## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }

    private static void println(String message) {
        System.out.println("\n" + message);
    }
}
