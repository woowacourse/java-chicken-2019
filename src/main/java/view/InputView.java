package view;

import domain.MenuRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MENU_CHICKEN_MIN = 1;
    private static final int MENU_CHICKEN_MAX = 6;
    private static final int MENU_BEVERAGE_MIN = 21;
    private static final int MENU_BEVERAGE_MAX = 22;
    private static final int TABLE_MAX_NUMBER=8;
    private static final int TABLE_MIDDLE_NUMBER=7;
    private static int caseNumber;
    private static int tableNumber;
    private static int menuNumber;
    private static int menuQuantity;

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        exceptionInputTable();
        return tableNumber;
    }

    /**
     * 1.주문등록, 2.결제하기, 3.프로그램종료 중 선택하는 기능입니다.
     *
     * @return 해당 번호가 리턴됩니다.
     */
    public static int inputMainFunction() {
        OutputView.printMain();
        System.out.println("## 원하는 기능을 선택해해주세요");
        exceptionInputMain();
        return caseNumber;
    }

    /**
     * 1.주문등록, 2.결제하기, 3.프로그램종료 중 이외의 입력에 대해 예외처리를 합니다.
     * 예외처리는 1,2,3 외의 숫자, 숫자가 아닌 input에 대해 예외처리 합니다.
     */
    public static void exceptionInputMain() {
        try {
            caseNumber = scanner.nextInt();
            if ((caseNumber < 1) || (caseNumber > 3)) {
                throw new IllegalArgumentException("1,2,3중 하나 입력");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            exceptionInputMain();
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력");
            scanner.nextLine();
            exceptionInputMain();
        }
    }

    /**
     * 메뉴를 고르는 메소드입니다.
     *
     * @return 해당 매뉴번호를 리턴합니다.
     */
    public static int InputMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요");
        exceptionInputMenu();
        return menuNumber;
    }

    /**
     * 메뉴 번호에 대한 예외처리입니다.
     *
     * 1.매뉴번호 이외의 입력 2.숫자이외의 입력에 대해 예외처리합니다
    */
    public static void exceptionInputMenu() {
        try {
            menuNumber = scanner.nextInt();
            if ((menuNumber < MENU_CHICKEN_MIN)
                    || (menuNumber > MENU_CHICKEN_MAX) && (menuNumber < MENU_BEVERAGE_MIN)
                    || (menuNumber > MENU_BEVERAGE_MAX)) {
                throw new IllegalArgumentException("해당 번호만 입력!!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            exceptionInputMenu();
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력");
            scanner.nextLine();
            exceptionInputMenu();
        }
    }

    public static int MenuQuantity(){
        System.out.println("## 메뉴의 수량을 입력하세요");
        exceptionINputMenuQuantity();
        return menuQuantity;
    }

    public static void exceptionINputMenuQuantity(){
        try {
            menuQuantity = scanner.nextInt();
            if ((menuQuantity < 0) || (menuQuantity > 99)) {
                throw new IllegalArgumentException("수량은 0이상,99를 초과할수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            exceptionInputMain();
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력");
            scanner.nextLine();
            exceptionInputMain();
        }
    }

    /**
     * 계산할 테이블의 번호를 입력하는 메소드입니다.
     *
     * @return 테이블의 번호
     */
    public static int inputPaymentTable() {
        System.out.println("## 테이블을 선택하세요.");
        exceptionInputTable();
        return tableNumber;
    }

    /**
     * 테이블 번호에 대한 예외처리
     */
    public static void exceptionInputTable(){
        try {
            tableNumber = scanner.nextInt();
            if ((tableNumber < 0) || (tableNumber > TABLE_MAX_NUMBER)||(tableNumber == TABLE_MIDDLE_NUMBER)) {
                throw new IllegalArgumentException("해당 테이블 번호만 입력!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            exceptionInputMain();
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력");
            scanner.nextLine();
            exceptionInputMain();
        }
    }


}
