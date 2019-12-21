package view;

import java.util.Optional;
import java.util.Scanner;

public class InputView {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return inputAsNumber();
    }

    public static int inputMainMenu() {
        OutputView.mainView();
        return Optional.of(inputAsNumber())
                .filter(InputView::isMainInputValid)
                .orElseGet(InputView::inputMainMenu);
    }

    public static boolean isMainInputValid(int input) {
        return input == ONE || input == TWO || input == THREE;
    }

    public static int inputAsNumber() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return inputTableNumber();
        }
    }
}
