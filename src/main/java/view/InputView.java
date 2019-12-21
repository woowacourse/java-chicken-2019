package view;

import domain.MenuRepository;
import domain.Tables;
import utility.ValidateUtility;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

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

    private static int inputInteger() {
        String input;
        do {
            input = scanner.nextLine();
        } while (!ValidateUtility.checkInteger(input));
        return Integer.parseInt(input);
    }

}
