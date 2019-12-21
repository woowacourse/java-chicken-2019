package view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_FUNCTION = "## 원하시는 기능을 선택하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionNumber() {
        System.out.println(SELECT_FUNCTION);

        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");

        return scanner.nextInt();
    }

}
