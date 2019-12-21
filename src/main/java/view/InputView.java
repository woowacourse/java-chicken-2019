package view;

import domain.MenuRepository;
import domain.TableRepository;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MINIMUM_MAIN_MENU = 1;
    private static final int MAXIMUM_MAIN_MENU = 3;
    private static final int MINIMUM_MENU_QUANTITY = 1;
    private static final int MAXIMUM_MENU_QUANTITY = 99;
    private static final int CARD = 1;
    private static final int CASH = 2;

    public static int inputMainNumber() {
        System.out.println("## 원하는 기능을 선택하세요");
        int mainNumber = SCANNER.nextInt();
        validatesMainNumber(mainNumber);
        return mainNumber;
    }

    private static void validatesMainNumber( int mainNumber ) {
        if (isOutMainMenu(mainNumber)) {
            System.out.println(mainNumber + "은 올바른 입력이 아닙니다.");
            inputMainNumber();
        }
    }

    private static boolean isOutMainMenu( int mainNumber ) {
        return (mainNumber < MINIMUM_MAIN_MENU) || (mainNumber > MAXIMUM_MAIN_MENU);
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        int tableNumber = SCANNER.nextInt();
        validatesTableNumber(tableNumber);
        return tableNumber;
    }

    public static int inputPaymentTableNumber() {
        System.out.println("## 결제할 테이블을 선택하세요.");
        int tableNumber = SCANNER.nextInt();
        validatesTableNumber(tableNumber);
        return tableNumber;
    }

    private static void validatesTableNumber( int tableNumber ) {
        List<Integer> tableNumbers = TableRepository.tableValues();
        if (!tableNumbers.contains(tableNumber)) {
            System.out.println(tableNumber + "는 없는 테이블 번호 입니다");
            inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        int menuNumber = SCANNER.nextInt();
        validatesMenuNumber(menuNumber);
        return menuNumber;
    }

    private static void validatesMenuNumber( int menuNumber ) {
        List<Integer> menuNumbers = MenuRepository.menuValues();
        if (!menuNumbers.contains(menuNumber)) {
            System.out.println(menuNumber + "는 없는 메뉴 번호 입니다.");
            inputMenuNumber();
        }
    }

    public static int inputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        int menuQuantity = SCANNER.nextInt();
        validatesMenuQuantity(menuQuantity);
        return menuQuantity;
    }

    private static void validatesMenuQuantity( int menuQuantity ) {
        if (isOutQuantityRange(menuQuantity)) {
            System.out.println(menuQuantity + "는 올바른 수량이 아닙니다.");
            inputMenuQuantity();
        }
    }

    private static boolean isOutQuantityRange( int menuQuantity ) {
        return (menuQuantity < MINIMUM_MENU_QUANTITY) || (menuQuantity > MAXIMUM_MENU_QUANTITY);
    }

    public static int inputPaymentMethod( int tableNumber ) {
        System.out.println("## " + tableNumber + "번 결제를 진행합니다.");
        System.out.println("## 카드는 1번, 현금은 2번");
        int paymentMethod = SCANNER.nextInt();
        validatesPaymentMethod(tableNumber, paymentMethod);
        return paymentMethod;
    }

    private static void validatesPaymentMethod( int tableNumber, int paymentMethod ) {
        if ((paymentMethod != CARD) && (paymentMethod != CASH)) {
            System.out.println(paymentMethod + "는 올바른 입력이 아닙니다.");
            inputPaymentMethod(tableNumber);
        }
    }
}
