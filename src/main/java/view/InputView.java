package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputSelectNumber() {
        return scanner.nextInt();
    }

    // 입력 버그 방지용 nextLine()
    public static String scanNextLine() {
        return scanner.nextLine();
    }
}
