package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPosFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return readIntegerByOneLine();
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return readIntegerByOneLine();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return readIntegerByOneLine();
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 선택하세요.");
        return readIntegerByOneLine();
    }

    private static int readIntegerByOneLine() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalUserInputException("정수만 입력 가능합니다.");
        }
    }
}
