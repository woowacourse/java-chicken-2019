package view;

import Check.Check;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");

        return scanner.nextInt();
    }

    public int inputFunction() {
        System.out.println("원하는 기능을 입력하세요.");
        String userInput = scanner.next();
        while (new Check().isInputFunctionError(userInput)) {
            userInput = scanner.next();
        }
        return Integer.parseInt(userInput);
    }
}
