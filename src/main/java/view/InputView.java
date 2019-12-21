package view;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFeature() {
        //TODO class Feature 만들고, 클래스 안에 기능 나열한 뒤, 하드코딩 삭제
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");
        System.out.println("## 기능을 선택하세요");

        int input = scanner.nextInt();
        if (!(1 <= input && input <= 3)) {
            System.out.println("메뉴를 보고 다시 입력하세요");
            input = inputFeature();
        }
        return input;
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPaymentMethod(int tableNumber) {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }

}
