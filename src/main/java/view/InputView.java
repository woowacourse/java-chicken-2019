package view;

import java.util.Scanner;

import util.ValidateUtil;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTodoSelect() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            int data = inputInt();
            ValidateUtil.validateFunctionId(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputTodoSelect();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            int data = inputInt();
            ValidateUtil.validateTableNumber(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputTodoSelect();
        }
    }
    public static int inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            int data = inputInt();
            ValidateUtil.validateMenuNumber(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputTodoSelect();
        }
    }

    public static int inputMenuQuantity() {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            int data = inputInt();
            ValidateUtil.validateMenuQuantity(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputTodoSelect();
        }
    }

    public static int inputCreditOrCash() {
        try {
            System.out.println("## 1번 테이블의 결제를 진행합니다.\n## 신용 카드는 1번, 현금은 2번");
            int data = inputInt();
            ValidateUtil.validatePaymentCode(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputTodoSelect();
        }
    }

    private static int inputInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return inputInt();
        }
    }
}
