package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMainFeatureNumber(){
        System.out.println("## 사용할 기능 번호를 선택하세요.");
        return scanner.nextLine();
    }
}
