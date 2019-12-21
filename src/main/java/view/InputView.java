package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * inputTableNumber는 테이블 번호를 입력받는 메서드이다.
     * @return 테이블 번호를 반환한다.
     * @exception InputMismatchException 잘못된 타입의 입력값이 들어오면 예외처리한다.
     */
    public static int inputTableNumber() {
        int inputNumber;
        System.out.println("## 주문할 테이블을 선택하세요.");
        try {
            inputNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 타입을 입력하셨습니다. 다시 입력해주세요.");
            scanner = new Scanner(System.in);
            return inputTableNumber();
        }
        return inputNumber;
    }

    /**
     * inputTableNumber는 주문/결제/종료에 대한 명령 번호(todoNumber)를 입력받는 메서드이다.
     *
     * @return 명령 번호를 반환한다.
     * @exception InputMismatchException 잘못된 타입의 입력값이 들어오면 예외처리한다.
     */
    public static int inputTodoNumber() {
        int inputNumber;
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            inputNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 타입을 입력하셨습니다. 다시 입력해주세요.");
            scanner = new Scanner(System.in);
            return inputTodoNumber();
        }
        return inputNumber;
    }
}
