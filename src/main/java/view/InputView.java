package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int REGIST_MENU = 1;
    private static final int MAKE_PAYMENT = 2;
    private static final int END_PROGRAM = 3;
    private static final int OFFSET = 0;
    private static final int LEAST_ORDER_COUNT = 1;
    private static final int BIGGIST_ORDER_COUNT = 99;
    private static int inputNumber;

    public static int inputOrderNumber() {
        OutputView.printOrderPage();
        while(!isOrderNumber());
        return inputNumber;
    }

    public static int inputTableNumber(List<Table> tables) {
        System.out.println("## 테이블을 선택하세요.");
        while(!isTableNumber(tables));
        System.out.println(inputNumber);
        return inputNumber;
    }

    public static int inputMenuNumber(List<Menu> menus) {
        System.out.println("## 등록할 메뉴를 선택해주세요");
        while(!isMenuNumber(menus));
        System.out.println(inputNumber);
        return inputNumber;
    }

    public static int inputChooseMenuCount() {
        System.out.println("## 메뉴 수량을 입력해주세요");
        while(!isChooseMenuNumber());
        System.out.println(inputNumber);
        return inputNumber;
    }

    private static boolean isChooseMenuNumber() {
        Scanner scanner = new Scanner(System.in);
        try{
            inputNumber = scanner.nextInt();
            checkChooseMenuNumber(inputNumber);
            return true;
        } catch(Exception e) {
            System.out.println("수량을 다시 입력해주세요");
            System.out.println(e.getMessage());
        }
        return false;

    }

    private static void checkChooseMenuNumber(int inputNumber) throws Exception {
        if(inputNumber < LEAST_ORDER_COUNT || inputNumber > BIGGIST_ORDER_COUNT) {
            throw new Exception("수량은 1~99까지 가능합니다");
        }
    }

    private static boolean isMenuNumber(List<Menu> menus) {
        Scanner scanner = new Scanner(System.in);
        try{
            inputNumber = scanner.nextInt();
            checkMenuNumber(inputNumber, menus);
            return true;
        } catch(Exception e) {
            System.out.println("올바른 메 번호를 입력해주세요");
        }
        return false;
    }

    private static void checkMenuNumber(int inputNumber, List<Menu> menus) throws Exception {
        int unCorrectTable = OFFSET;
        for(Menu menu : menus) {
            if(menu.getNumber() == inputNumber) {
                return;
            }
        }
        if(unCorrectTable != menus.size()) {
            throw new Exception();
        }
    }

    private static boolean isTableNumber(List<Table> tables) {
        Scanner scanner = new Scanner(System.in);
        try{
            inputNumber = scanner.nextInt();
            checkTableNumber(inputNumber, tables);
            return true;
        } catch(Exception e) {
            System.out.println("올바른 테이블 번호를 입력해주세요");
        }
        return false;
    }

    private static void checkTableNumber(int inputNumber, List<Table> tables) throws Exception {
        int unCorrectTable = 0;
        for(Table table : tables) {
            if(table.getNumber() == inputNumber) {
                return;
            }
        }
        if(unCorrectTable != tables.size()) {
            throw new Exception("올바른 테이블 번호를 입력해주시기 바랍니다.");
        }
    }

    private static boolean isOrderNumber() {
        Scanner scanner = new Scanner(System.in);
        try{
            inputNumber = scanner.nextInt();
            checkOrderNumber(inputNumber);
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.printf("다시 입력해주세요\n\n");
            OutputView.printOrderPage();
        }
        return false;

    }

    private static void checkOrderNumber(int inputNumber) throws Exception {
        if(inputNumber != REGIST_MENU && inputNumber != MAKE_PAYMENT && inputNumber != END_PROGRAM) {
            throw new IllegalAccessException("메인 화면에 있는 값만 입력해주세요");
       }
    }

    public static int inputPaymentMethod() {
        while(!isPaymentMethodNumber());
        return inputNumber;
    }

    private static boolean isPaymentMethodNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("신용카드는 1번, 현금은 2번 ");
        try{
            inputNumber = scanner.nextInt();
            checkPaymentMethod(inputNumber);
            return true;
        } catch(Exception e) {
            System.out.println("결제 수을 다시 입력해주세요");
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void checkPaymentMethod(int inputNumber) throws Exception {
        if(inputNumber != 1 && inputNumber != 2) {
            throw new Exception("제대로된 결제 방법을 입력해주세요");
        }
    }
}
