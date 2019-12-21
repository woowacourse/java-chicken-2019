package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        int command = scanner.nextInt();
        if(command != 1 && command != 2 &&command != 3) {
        	throw new IllegalArgumentException("1,2,3이외의 수는 입력할 수 없습니다");
        }
        return command;
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
