package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionNumber() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return inputFunctionNumber();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return inputTableNumber();
        }
    }

    public static int inputMenuToRegister() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return inputMenuToRegister();
        }
    }

    public static int inputMenuAmount() {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return inputMenuAmount();
        }
    }

    private static String input() {
        return scanner.nextLine();
    }
}
