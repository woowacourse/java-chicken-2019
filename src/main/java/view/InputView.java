package view;

import domain.MenuRepository;
import domain.Tables;
import utility.ValidateUtility;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String MESSAGE_SHARP = "## ";
    public static final String MESSAGE_START_PAYMENT = "번 테이블의 결제를 진행합니다.";
    public static final String MESSAGE_SELECT_PAYMENT_METHOD = "## 신용카드는 1번, 현금은 2번";

    public static int inputTableNumber(Tables tables) {
        int tableNumber = 0;
        System.out.println("## 주문할 테이블을 선택하세요.");
        do {
            tableNumber = inputInteger();
        } while (!tables.hasTableNumber(tableNumber));

        return tableNumber;
    }

    public static int inputMainMenuNumber() {
        int menuNumber = 0;
        System.out.println("## 원하는 기능을 선택하세요");
        do {
            menuNumber = inputInteger();
        } while (!MenuRepository.hasMenuNumber(menuNumber));

        return menuNumber;
    }

    public static int inputMenuNumber() {
        int mainMenuNumber = 0;
        System.out.println("## 등록할 메뉴를 선택하세요");
        do {
            mainMenuNumber = inputInteger();
        } while (!MenuRepository.hasMenuNumber(mainMenuNumber));

        return mainMenuNumber;
    }

    public static int inputMenuQuantity() {
        int menuQuantityNumber = 0;
        System.out.println("## 메뉴의 수량을 선택하세요");
        do {
            menuQuantityNumber = inputInteger();
        } while (!ValidateUtility.validateMenuQuantity(menuQuantityNumber));

        return menuQuantityNumber;
    }

    public static int inputPaymentMethod(int tableNumber) {
        int paymentMethod = 0;
        System.out.println(MESSAGE_SHARP + tableNumber + MESSAGE_START_PAYMENT);
        System.out.println(MESSAGE_SELECT_PAYMENT_METHOD);
        do {
            paymentMethod = inputInteger();
        } while (!ValidateUtility.validatePaymentMethod(paymentMethod));

        return paymentMethod;
    }


    public static void inputNothing() {
        scanner.nextLine();
    }

    private static int inputInteger() {
        String input;
        do {
            input = scanner.nextLine();
        } while (!ValidateUtility.checkInteger(input));
        return Integer.parseInt(input);
    }

}
