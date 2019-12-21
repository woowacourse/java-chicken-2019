package view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final String NEWLINE = "\n";
    private static final int VALUE_MIN = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println(NEWLINE + "## 주문할 테이블을 선택하세요.");
        int value = scanner.nextInt();

        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("테이블 번호는 'null'이 될 수 없습니다.");
        }
        if (value < VALUE_MIN) {
            throw new IllegalArgumentException("테이블 번호는 0보다 커야합니다.");
        }

        return value;
    }

    public static int inputMenu() {
        System.out.println(NEWLINE + "원하는 기능을 선택하세요.");
        int value = scanner.nextInt();

        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("원하는 기능 번호는 'null'이 될 수 없습니다.");
        }
        if (value < VALUE_MIN) {
            throw new IllegalArgumentException("테이블 번호는 0보다 커야합니다.");
        }

        return value;
    }

    public static int inputOrder() {
        System.out.println(NEWLINE + "등록할 메뉴를 선택하세요.");
        int value = scanner.nextInt();

        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("메뉴는 'null'이 될 수 없습니다.");
        }
        if (value < VALUE_MIN) {
            throw new IllegalArgumentException("테이블 번호는 0보다 커야합니다.");
        }

        return value;
    }

    public static int inputCount() {
        System.out.println(NEWLINE + "메뉴의 수량을 입력하세요.");
        int value = scanner.nextInt();

        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("수량은 'null'이 될 수 없습니다.");
        }
        if (value < VALUE_MIN) {
            throw new IllegalArgumentException("테이블 번호는 0보다 커야합니다.");
        }

        return value;
    }
}
