package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCatcher {
    private static Scanner scanner = new Scanner(System.in);

    final static int ORDER_LIMIT_PER_MENU = 99;
    final static int ORDER_MUST_MORE_ONE = 1;

    public static int isInt() {
        while (true) {

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.println("## 정수만 입력할 수 있습니다!");
            }

        }
    }

    public static boolean isOverHundred(int howMany) {
        boolean isOver = howMany < ORDER_LIMIT_PER_MENU
                && howMany < ORDER_MUST_MORE_ONE;
        if (isOver) {
            System.out.println("## 메뉴는 1이상 99이하로 입력하세요!");
            return isOver;
        }

        return isOver;
    }
}
