package view;

import domain.Menu;
import domain.MenuRepository;
import domain.Menus;
import domain.Table;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuQuantity() {
        System.out.println("메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
}
