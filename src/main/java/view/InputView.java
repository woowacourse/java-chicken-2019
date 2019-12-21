package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import domain.PosMenuType;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static PosMenuType inputPosMenu() {
        System.out.println("## 메인화면\n1: 주문등록\n2: 결제하기\n3: 프로그램 종료\n");
        try {
            System.out.println("## 원하시는 기능을 선택하세요.");
            String input = scanner.nextLine();
            return PosMenuType.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println("## 잘못된 입력입니다. 다시 입력해주세요");
            return inputPosMenu();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("## 잘못된 입력입니다. 다시 입력해주세요");
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("## 잘못된 입력입니다. 다시 입력해주세요");
            return inputMenuNumber();
        }
    }

    public static int inputPurchaseCount() {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("## 잘못된 입력입니다. 다시 입력해주세요");
            return inputPurchaseCount();
        }
    }
}
