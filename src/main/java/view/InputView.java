package view;

import domain.MainFeatureNumber;
import domain.MenuCount;
import domain.MenuNumber;
import domain.TableNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainFeatureNumber getMainFeatureNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        while (true) {
            try {
                return new MainFeatureNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static TableNumber getTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        while (true) {
            try {
                return new TableNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static MenuNumber getMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        while (true) {
            try {
                return new MenuNumber(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static MenuCount getMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        while (true) {
            try {
                return new MenuCount(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
