package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMainMenu() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        return isInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return isInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return isInt();
    }

    public static int inputHowManyMenu() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return isInt();
    }

    private static int isInt() {
        while (true) {

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.println("정수만 입력할 수 있습니다!");
            }

        }
    }

}
