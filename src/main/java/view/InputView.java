package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static int caseNumber;

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
        System.out.println("## 원하는 기능을 선택해해주세요");
        exceptionInput();
        return caseNumber;
    }

    /**
     * 1.주문등록, 2.결제하기, 3.프로그램종료 중 이외의 입력에 대해 예외처리를 합니다.
     * 예외처리는 1,2,3 외의 숫자, 숫자가 아닌 input에 대해 예외처리 합니다.
     */
    public static void exceptionInput(){
        try {
            caseNumber = scanner.nextInt();
            if ((caseNumber < 0) || (caseNumber > 4)) {
                throw new IllegalArgumentException("1,2,3중 하나 입력");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            exceptionInput();
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력");
            scanner.nextLine();
            exceptionInput();
        }
    }
}
