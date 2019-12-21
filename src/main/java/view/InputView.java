package view;

import java.sql.SQLOutput;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMain() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumberForOrder() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumberForCharge() {
        System.out.println("## 결제할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
