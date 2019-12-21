package view;

import domain.Menu;
import domain.Table;

import java.lang.invoke.MutableCallSite;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int MAX_CHOICE_NUMBER = 3;
    private static final int MIN_CHOICE_NUMBER = 1;
    private static final int MAX_COUNT_NUMBER = 99;
    private static final int MIN_COUNT_NUMBER = 1;
    private static final int CARD_NUMBER = 1;
    private static final int CASH_NUMBER = 2;

    private static final Scanner scanner = new Scanner(System.in);

    public static void inputMainPrint() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static int inputFunctionNumber() {
        inputMainPrint();
        System.out.println("## 원하는 기능을 선택하세요.");
        String inputFunctionNumber = scanner.nextLine();
        while (!functionNumberValidator(inputFunctionNumber) || !isOneTwoThree(Integer.parseInt(inputFunctionNumber))) {
            System.out.println("숫자 1, 2, 3만 가능 합니다.");
            System.out.println("## 원하는 기능을 선택하세요.");
            inputFunctionNumber = scanner.nextLine();
        }

        return Integer.parseInt(inputFunctionNumber);
    }

    private static boolean functionNumberValidator(String inputFunctionNumber) {
        try {
            Integer.parseInt(inputFunctionNumber);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }

    }

    private static boolean isOneTwoThree(int number) {
        return number >= MIN_CHOICE_NUMBER && number <= MAX_CHOICE_NUMBER;
    }

    public static int inputTableNumber(List<Table> tables) {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String inputTableNumber = scanner.nextLine();
        while (!functionNumberValidator(inputTableNumber) || !isTable(tables, inputTableNumber)) {
            System.out.println("나와있는 테이블 번호를 입력하세요.");
            System.out.println("## 주문할 테이블을 선택하세요.");
            inputTableNumber = scanner.nextLine();
        }
        return Integer.parseInt(inputTableNumber);
    }

    private static boolean isTable(List<Table> tables, String inputTableNumber) {
        for (Table table: tables) {
            if (table.toString().equals(inputTableNumber)) {
                return true;
            }
        }
        return false;
    }

    public static int inputTableBillNumber(List<Table> tables) {
        System.out.println("## 계산할 테이블을 선택하세요.");
        String inputTableBillNumber = scanner.nextLine();
        while (!functionNumberValidator(inputTableBillNumber) || !isTable(tables, inputTableBillNumber)) {
            System.out.println("나와있는 테이블 번호를 입력하세요.");
            System.out.println("## 주문할 테이블을 선택하세요.");
            inputTableBillNumber = scanner.nextLine();
        }
        return Integer.parseInt(inputTableBillNumber);
    }

    public static int inputMenuNumber(List<Menu> menus) {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String inputMenuNumber = scanner.nextLine();
        while (!functionNumberValidator(inputMenuNumber) || !isMenus(menus, Integer.parseInt(inputMenuNumber))) {
            System.out.println("나와있는 메뉴를 입력하세요.");
            System.out.println("## 주문할 테이블을 선택하세요.");
            inputMenuNumber = scanner.nextLine();
        }
        return Integer.parseInt(inputMenuNumber);
    }

    private static boolean isMenus(List<Menu> menus, int inputMenuNumber) {
        for (Menu menu: menus) {
            if (menu.isNumber(inputMenuNumber)) {
                return true;
            }
        }
        return false;
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String inputMenuCount = scanner.nextLine();
        while (!functionNumberValidator(inputMenuCount) || !isMaxNumber(Integer.parseInt(inputMenuCount))) {
            System.out.println("올바른 숫자 입력을 하세요.(최소 1, 최대 99)");
            System.out.println("## 메뉴의 수량을 입력하세요.");
            inputMenuCount = scanner.nextLine();
        }
        return Integer.parseInt(inputMenuCount);
    }

    private static boolean isMaxNumber(int inputMenuCount) {
        return inputMenuCount >= MIN_COUNT_NUMBER && inputMenuCount <= MAX_COUNT_NUMBER;
    }

    public static int inputCardOrCash() {
        System.out.println("## 신용카드는 1번 ,현금은 2번");
        String inputCardOrCash = scanner.nextLine();
        while (!functionNumberValidator(inputCardOrCash) || !isOneOrTwo(Integer.parseInt(inputCardOrCash))) {
            System.out.println("올바른 숫자 입력을 하세요.(1 Or 2)");
            System.out.println("## 메뉴의 수량을 입력하세요.");
            inputCardOrCash = scanner.nextLine();
        }
        return Integer.parseInt(inputCardOrCash);
    }

    private static boolean isOneOrTwo(int inputCardOrCash) {
        return inputCardOrCash == CARD_NUMBER || inputCardOrCash == CASH_NUMBER;
    }
}
