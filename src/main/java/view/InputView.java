package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPosChoice() {
        return inputInteger("## 원하는 기능을 선택하세요.");
    }

    public static int inputTableNumber() {
        return inputInteger("## 테이블을 선택하세요.");
    }

    public static int inputFoodNumber() {
        return inputInteger( "## 등록할 메뉴를 선택하세요.");
    }

    public static int inputFoodCount() {
        return inputInteger("## 메뉴의 수량을 입력하세요.");
    }

    public static int inputInteger(String text) {
        System.out.println(text);
        String input = scanner.nextLine();
        try {
            validateInteger(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputInteger(text);
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
