package view;

import validation.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int getMainFunctionNumber() {
        int inputInt;
        do {
            OutputView.printMainFunction();
            inputInt = getInputInt();
        } while (!InputValidator.inputMainFunctionValidator(inputInt));
        return inputInt;
    }

    public static int getInputInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            OutputView.askReenterOnlyInteger();
            return getInputInt();
        }
    }
}
