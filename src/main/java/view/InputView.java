package view;

import domain.MenuFeatureNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MenuFeatureNumber inputMenuFeatureNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        while (true) {
            try {
                return new MenuFeatureNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
