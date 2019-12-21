package view;

import domain.Menu;
import domain.Table;
import except.InputException;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static int YES_OR_NO = 2;
    private final static int MAIN_MENU_LENGTH = 3;
    private final static int ORDER_LENGTH = 100;

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber(List<Table> tables) {
        System.out.println("## 테이블을 선택하세요.");
        String number = scanner.next();
        if (!InputException.isNumber(number))
            return inputTableNumber(tables);
        int tableNumber = Integer.parseInt(number);
        if (InputException.tableNumberException(tables, tableNumber))
            return inputTableNumber(tables);
        return tableNumber;
    }

    public static int inputMenuNumber(List<Menu> menus) {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String number = scanner.next();
        if (!InputException.isNumber(number))
            return inputMenuNumber(menus);
        int menuNumber = Integer.parseInt(number);
        if (InputException.menuNumberException(menus, menuNumber))
            return inputMenuNumber(menus);
        return menuNumber;
    }

    public static int inputMenuQuantityNumber() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String tempCount = scanner.next();
        if (!InputException.isNumber(tempCount)) {
            return inputMenuQuantityNumber();
        }
        int count = Integer.parseInt(tempCount);
        if (!InputException.isRange(count, ORDER_LENGTH))
            return inputMenuQuantityNumber();
        return count;
    }

    public static int inputCardOrCash(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용카드는 1번, 현금은 2번");
        String number = scanner.next();
        if (!InputException.isNumber(number))
            return inputCardOrCash(tableNumber);
        int count = Integer.parseInt(number);
        if (!InputException.isRange(count, YES_OR_NO + 1))
            return inputCardOrCash(tableNumber);
        return count;
    }

    public static int inputMainFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String number = scanner.next();
        if (!InputException.isNumber(number))
            return inputMainFunction();
        int count = Integer.parseInt(number);
        if (!InputException.isRange(count, MAIN_MENU_LENGTH + 1))
            return inputMainFunction();
        return count;

    }
}
