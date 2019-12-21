package view;

import utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Validator validator = new Validator();

    public static int inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            inputOnlyInteger();
            return validator.isValidFunctionNumber(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputFunctionNumber();
        }
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        try {
            inputOnlyInteger();
            return validator.isValidTableNumber(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        try {
            inputOnlyInteger();
            return validator.isValidMenuNumber(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMenuNumber();
        }
    }

    public static int inputAmount() {
        System.out.println("\n## 메뉴의 수량을 입력하세요.");
        try {
            inputOnlyInteger();
            return validator.isValidAmount(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    public static int inputPaymentMethod(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        try {
            inputOnlyInteger();
            return validator.isValidPaymentMethod(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPaymentMethod(tableNumber);
        }
    }

    private static void inputOnlyInteger() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("정수를 입력하세요.");
        }
    }
}
