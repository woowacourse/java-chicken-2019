package view;

import domain.TableRepository;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputProvidingFunctionNumber() {
        int providingFunctionNumber = -1;

        System.out.println("## 원하는 기능을 선택하세요.");
        providingFunctionNumber = scanner.nextInt();

        while (!isProvidingFunctionNumberCorrect(providingFunctionNumber)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println("## 원하는 기능을 선택하세요.");
            providingFunctionNumber = scanner.nextInt();
        }

        return providingFunctionNumber;
    }

    private static boolean isProvidingFunctionNumberCorrect(int providingFunctionNumber) {
        return true;
    }

    public static int inputTableNumber() {
        int tableNumber;

        System.out.println("## 주문할 테이블을 선택하세요.");
        tableNumber = scanner.nextInt();

        while (!isTableNumberCorrect(tableNumber)) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            System.out.println("## 주문할 테이블을 선택하세요.");
            tableNumber = scanner.nextInt();
        }

        return tableNumber;
    }

    private static boolean isTableNumberCorrect(int tableNumber) {

        if (TableRepository.isExistTableNumber(tableNumber)) {
            return true;
        }

        return false;
    }

    public static int inputMenuChoice() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputNumberOfMenu() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputCardOrCash() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
