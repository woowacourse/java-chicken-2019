package view;

import domain.*;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainFeatureNumber getMainFeatureNumber() {
        while (true) {
            System.out.println("## 원하는 기능을 선택하세요.");
            try {
                return new MainFeatureNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static TableNumber getTableNumber() {
        while (true) {
            System.out.println("## 테이블을 선택하세요.");
            try {
                return new TableNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static TableNumber getUnpaidTableNumber() {
        while (true) {
            System.out.println("## 테이블을 선택하세요.");
            try {
                return new TableNumber(scanner.nextLine(), true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static MenuNumber getMenuNumber() {
        while (true) {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            try {
                return new MenuNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static MenuCount getMenuCount() {
        while (true) {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            try {
                return new MenuCount(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PaymentMethod getPaymentMethod() {
        while (true) {
            System.out.println("## 신용 카드는 1번, 현금은 2번");
            try {
                return new PaymentMethod(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
