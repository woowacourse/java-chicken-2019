package view;

import domain.MenuRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    protected static final int MENU_CHICKEN_MIN = 1;
    protected static final int MENU_CHICKEN_MAX = 6;
    protected static final int MENU_BEVERAGE_MIN = 21;
    protected static final int MENU_BEVERAGE_MAX = 22;
    private static int caseNumber;
    private static int MenuNumber;
    private static int MenuQuantity;

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
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
        return MenuNumber;
    }

    /**
     * 메뉴 번호에 대한 예외처리입니다.
     *
     * 1.매뉴번호 이외의 입력 2.숫자이외의 입력에 대해 예외처리합니다
    */
    public static void exceptionInputMenu() {
        try {
            MenuNumber = scanner.nextInt();
            if ((MenuNumber < MENU_CHICKEN_MIN)
                    || (MenuNumber > MENU_CHICKEN_MAX) && (MenuNumber < MENU_BEVERAGE_MIN)
                    || (MenuNumber > MENU_BEVERAGE_MAX)) {
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
        return MenuQuantity;
    }

    public static void exceptionINputMenuQuantity(){
        try {
            MenuQuantity = scanner.nextInt();
            if ((MenuQuantity < 0) || (MenuQuantity > 99)) {
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

}
