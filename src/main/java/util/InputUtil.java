package util;

import java.util.Scanner;

public class InputUtil {
    private final static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return inputInt();
        }
    }
}
