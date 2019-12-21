package view;

import domain.Tables;

import java.util.Optional;
import java.util.Scanner;

public class InputView {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber(Tables tables) {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return Optional.of(inputAsNumber())
                .filter(tables::isTableExist)
                .orElseGet(() -> {
                    System.out.println("존재하지않는 테이블 번호입니다.");
                    return inputTableNumber(tables);
                });
    }

    public static int inputMainMenu() {
        OutputView.mainView();
        return Optional.of(inputAsNumber())
                .filter(InputView::isMainInputValid)
                .orElseGet(InputView::inputMainMenu);
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return inputAsNumber();
    }

    public static boolean isMainInputValid(int input) {
        return input == ONE || input == TWO || input == THREE;
    }

    public static int inputAsNumber() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return inputAsNumber();
        }
    }
}
