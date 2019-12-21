package view;

import view.InputView;
import view.CheckValidity;

public class CheckValidity {
    public static int checkMainMenuNumber(int mainNumber) {
        if(mainNumber < 1 || mainNumber > 3) {
            System.out.println("잘못된 입력입니다.");
            return InputView.inputMainNumber();
        }
        return mainNumber;
    }

    public static int checkTableNumber(int tableNumber) {
        tableNumber = convertTableNumber(tableNumber);
        if(tableNumber == -1) {
            System.out.println("없는 테이블입니다.");
            return InputView.inputTableNumber();
        }
        return tableNumber;
    }

    public static int checkOrderMenu(int menuNumber) {
        if (menuNumber < 1 || (menuNumber > 6 && menuNumber != 21 && menuNumber != 22)) {
            System.out.println("없는 메뉴입니다.");
            return InputView.selectOrderMenu();
        }
        return menuNumber;
    }

    public static int checkCountMenu(int menuCount) {
        if(menuCount < 1 || menuCount > 99) {
            System.out.println("주문은 1개 이상 99개 이하만 가능합니다.");
            return InputView.selectCountMenu();
        }
        return menuCount;
    }

    public static int checkPayment(int paymentNumber) {
        if(paymentNumber != 1 && paymentNumber != 2) {
            System.out.println("잘못된 입력입니다.");
            return InputView.selectPaymentNumber();
        }
        return paymentNumber;
    }

    public static int convertTableNumber(int input) {
        if(input >= 1 && input <= 3) {
            return input - 1;
        }
        else if (input == 5) {
            return 3;
        }
        else if (input == 6) {
            return 4;
        }
        else if (input == 8) {
            return 5;
        }
        return -1;
    }
}