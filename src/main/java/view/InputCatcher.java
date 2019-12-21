package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCatcher {
    private static Scanner scanner = new Scanner(System.in);

    private static final String ANNOUNCE_ONLY_INTEGER = "## 정수만 입력할 수 있습니다!";
    private static final String ANNOUNCE_MENU_LIMIT = "## 메뉴는 1이상 99이하로 입력하세요!";

    private static final int ORDER_LIMIT_PER_MENU = 99;
    private static final int ORDER_MUST_MORE_ONE = 1;

    public static int isInt() {
        while (true) {

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.println(ANNOUNCE_ONLY_INTEGER);
            }

        }
    }

    public static boolean isOverHundred(int howMany) {
        boolean isOver = howMany < ORDER_LIMIT_PER_MENU
                && howMany < ORDER_MUST_MORE_ONE;
        if (isOver) {
            System.out.println(ANNOUNCE_MENU_LIMIT);
            return isOver;
        }

        return isOver;
    }
}
