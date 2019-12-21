package view;

import java.util.Scanner;

import domain.MenuRepository;
import domain.TableRepository;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static final int ORDER = 1;
    public static final int PAY = 2;
    public static final int CLOSE = 3;

    private static int execptionInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\n!!잘못 입력하셨습니다. 다시 입력해주세요.");
                scanner.nextLine();
                return scanner.nextInt();
            }
        }
    }

    public static int inputMainNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return execptionInputMainNumber(execptionInput());
    }

    private static int execptionInputMainNumber(int input) {
        while (input < ORDER || input > CLOSE) {
            System.out.println("\n!!잘못 입력하셨습니다. 다시 입력해주세요.");
            input = scanner.nextInt();
        }
        return input;
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return execptionInputTableNumber(execptionInput());
    }

    private static int execptionInputTableNumber(int input) {
        if (!TableRepository.checkTable(input)) {
            System.out.println("\n!!잘못 입력하셨습니다. 다시 입력해주세요.");
            input = scanner.nextInt();
            return execptionInputTableNumber(input);
        }
        return input;
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return execptionInputMenuNumber(execptionInput());
    }

    private static int execptionInputMenuNumber(int input) {
        if (!MenuRepository.checkMenu(input)) {
            System.out.println("\n!!잘못 입력하셨습니다. 다시 입력해주세요.");
            input = scanner.nextInt();
            return execptionInputMenuNumber(input);
        }
        return input;
    }

    public static int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return execptionInput();
    }

    public static int inputPayTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return execptionInput();
    }

    public static int inputPayNumber(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return execptionInput();
    }
}
