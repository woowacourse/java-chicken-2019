package view;

import domain.MainFeatureNumber;
import domain.TableNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainFeatureNumber inputMainFeatureNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        while (true) {
            try {
                return new MainFeatureNumber(scanner.nextLine());
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
