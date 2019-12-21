package view;

import org.graalvm.compiler.debug.CSVUtil;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 주문할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuQuantity() {
        System.out.println("## 메뉴의 갯수를 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputMainFeature() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
