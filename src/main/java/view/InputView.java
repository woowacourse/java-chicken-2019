package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMainNumber() {
        System.out.println("##메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n");
        System.out.println("## 원하는 기능을 선택하세요.");
        return CheckValidity.checkMainMenuNumber(scanner.nextInt());
    }
    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return CheckValidity.checkTableNumber(scanner.nextInt());
    }

    public static int selectOrderMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return CheckValidity.checkOrderMenu(scanner.nextInt());
    }

    public static int selectCountMenu() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int selectPaymentNumber() {
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
