package view;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;

import java.util.Scanner;

/**
 * 사용자의 입력을 받는 클래스
 */
public final class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAction() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문하기");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        return ExceptionDetect.actionInputException(scanner.nextInt());
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return ExceptionDetect.tableInputException(scanner.nextInt());
    }

    public static Menu inputOrderMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        int number = ExceptionDetect.orderMenuException(scanner.nextInt());
        return MenuRepository.getMenu(number);
    }

    public static int inputOrderCount(Table table, Menu menu) {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        int number = scanner.nextInt();
        while (!ExceptionDetect.orderCountException(number, table, menu))
            number = scanner.nextInt();
        return number;
    }
}
