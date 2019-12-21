package view;

import java.util.Scanner;

import static util.InputUtil.inputInt;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputNextStep() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return inputInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return inputInt();
    }
}
