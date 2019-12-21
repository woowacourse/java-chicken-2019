package view;

import domain.*;

import java.util.Optional;
import java.util.Scanner;

public class InputView {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int MAX_AMOUNT = 99;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber(Tables tables) {
        OutputView.printTables(tables.getTables());
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

    public static int inputMenuNumber(Menus menus) {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        OutputView.printMenus(menus.getMenus());
        return Optional.of(inputAsNumber())
                .filter(menus::isMenuExist)
                .orElseGet(() -> {
                    System.out.println("존재하지않는 메뉴 번호입니다.");
                    return inputMenuNumber(menus);
                });
    }

    public static int inputMenuAmount(Table table, Menu inputMenu) {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return Optional.of(inputAsNumber())
                .filter(x -> isNotOverThenMaxAmount(table, inputMenu, x))
                .filter(InputView::isNotLessEqualThenZero)
                .orElseGet(() -> {
                    System.out.println("추가하려는 메뉴가 99개를 넘었거나 1보다 작습니다.");
                    return inputMenuAmount(table, inputMenu);
                });
    }

    private static boolean isNotOverThenMaxAmount(Table table, Menu inputMenu, int inputCount) {
        return table.countOfMenu(inputMenu) + inputCount <= MAX_AMOUNT;
    }

    private static boolean isNotLessEqualThenZero(int inputCount) {
        return inputCount > 0;
    }

    public static int inputPaymentMethod() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return Optional.of(inputAsNumber())
                .filter(InputView::isPaymentInputValid)
                .orElseGet(InputView::inputPaymentMethod);
    }

    private static boolean isPaymentInputValid(int input) {
        return input == Calculator.CARD_PAYMENT || input == Calculator.CASH_PAYMENT;
    }

    private static boolean isMainInputValid(int input) {
        return input == ONE || input == TWO || input == THREE;
    }

    private static int inputAsNumber() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return inputAsNumber();
        }
    }
}
