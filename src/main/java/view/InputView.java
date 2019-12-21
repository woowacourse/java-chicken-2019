package view;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final String NEW_LINE = "\n";
    private static final int VALUE_MIN = 0;
    private static final int PAY_METHOD = 2;
    private static final int MENU_MAX = 3;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println(NEW_LINE + "## 테이블을 선택하세요.");
        try {
            int value = scanner.nextInt();

            if (Objects.isNull(value)) {
                throw new IllegalArgumentException("테이블 번호는 'null'이 될 수 없습니다.");
            }
            if (value < VALUE_MIN || value > MENU_MAX) {
                throw new IllegalArgumentException("테이블 번호는 0보다 커야합니다.");
            }

            return value;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("양의 정수의 숫자를 입력해야 합니다.");
        }
    }

    public static int inputMenu() {
        System.out.println(NEW_LINE + "원하는 기능을 선택하세요.");
        try {
            int value = scanner.nextInt();

            if (Objects.isNull(value)) {
                throw new IllegalArgumentException("원하는 기능 번호는 'null'이 될 수 없습니다.");
            }
            if (value < VALUE_MIN || value > MENU_MAX) {
                throw new IllegalArgumentException("원하는 기능 번호는 1~3 사이여야 합니다.");
            }
            return value;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("양의 정수의 숫자를 입력해야 합니다.");
        }
    }

    public static int inputOrder() {
        System.out.println(NEW_LINE + "등록할 메뉴를 선택하세요.");
        try {
            int value = scanner.nextInt();

            if (Objects.isNull(value)) {
                throw new IllegalArgumentException("메뉴는 'null'이 될 수 없습니다.");
            }
            if (value < VALUE_MIN) {
                throw new IllegalArgumentException("메뉴는 0보다 커야합니다.");
            }
            return value;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("양의 정수의 숫자를 입력해야 합니다.");
        }
    }

    public static int inputCount() {
        System.out.println(NEW_LINE + "메뉴의 수량을 입력하세요.");
        try {
            int value = scanner.nextInt();

            if (Objects.isNull(value)) {
                throw new IllegalArgumentException("수량은 'null'이 될 수 없습니다.");
            }
            if (value < VALUE_MIN) {
                throw new IllegalArgumentException("수량은 0보다 커야합니다.");
            }
            return value;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("양의 정수의 숫자를 입력해야 합니다.");
        }
    }

    public static int printPay(int tableNumber) {
        System.out.println(NEW_LINE + "## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("신용 카드는 1번, 현금은 2번");
        try {
            int value = scanner.nextInt();

            if (Objects.isNull(value)) {
                throw new IllegalArgumentException("지불방법은 'null'이 될 수 없습니다.");
            }
            if (value < VALUE_MIN || value > PAY_METHOD) {
                throw new IllegalArgumentException("지불방법은 1 또는 2이어야 합니다.");
            }
            return value;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("양의 정수의 숫자를 입력해야 합니다.");
        }
    }
}
