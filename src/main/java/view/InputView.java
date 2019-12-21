package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTodoSelect() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return inputInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return inputInt();
    }
    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return inputInt();
    }

    public static int inputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return inputInt();
    }

    public static int inputCreditOrCash() {
        System.out.println("## 1번 테이블의 결제를 진행합니다.\n## 신용 카드는 1번, 현금은 2번");
        return inputInt();
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
