package view;

import exceptions.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInputOfMainUI() {
        System.out.println("원하시는 기능을 입력해주세요.(1-3)");
        String inputOfMainUI = scanner.nextLine();
        try {
            Validator.checkInputOfMainUI(inputOfMainUI);
            return Integer.parseInt(inputOfMainUI);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputOfMainUI();
        }
    }

    public static int getInputOfTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String inputOfTableNumber = scanner.nextLine();
        try {
            Validator.checkInputOfTableNumber(inputOfTableNumber);
            return Integer.parseInt(inputOfTableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputOfTableNumber();
        }
    }
}
