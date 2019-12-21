package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * inputTableNumber는 테이블 번호를 입력받는 메서드이다.
     *
     * @return 테이블 번호를 반환한다.
     */
    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return inputIntValueWithException();
    }

    /**
     * inputTableNumber는 주문/결제/종료에 대한 명령 번호(todoNumber)를 입력받는 메서드이다.
     *
     * @return 명령 번호를 반환한다.
     */
    public static int inputTodoNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return inputIntValueWithException();
    }

    /**
     * inputMenuCode는 주문할 메뉴 번호가 어떤 것인지 입력받는 메서드이다.
     *
     * @return 입력된 메뉴 번호를 반환한다.
     */
    public static int inputMenuCode() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return inputIntValueWithException();
    }

    /**
     * inputMenuNumber는 메뉴를 몇개 주문할 것인지 입력받는 메서드이다.
     *
     * @return 입력된 메뉴 개수를 반환한다.
     */
    public static int inputMenuNumber() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return inputIntValueWithException();
    }

    /**
     * inputIntValueWithException은 정수값을 입력받아 반환하는 메서드이다.
     * 예외처리를 포함하여, 만약 정수가 아닌 값이 들어오면 예외처리 후 다시 입력받는다.
     *
     * @return 입력받은 정수값을 반환한다.
     * @throws InputMismatchException 입력이 정수가 아니라면 예외처리한다.
     */
    private static int inputIntValueWithException() {
        int inputNumber;
        try {
            inputNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 타입을 입력하셨습니다. 다시 입력해주세요.");
            scanner = new Scanner(System.in);
            return inputIntValueWithException();
        }
        return inputNumber;
    }
}
