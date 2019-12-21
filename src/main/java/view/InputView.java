package view;

import domain.TableConfig;
import domain.errors.InvalidInputException;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        try {
            int tableNumber = Integer.parseInt(scanner.nextLine());
            if (Arrays.stream(TableConfig.TABLES_NUMBERS).parallel().noneMatch(number -> number == tableNumber )) {
                throw new InvalidInputException("테이블에 속하지 않는 번호입니다.");
            }
            return tableNumber;

        } catch (RuntimeException e) {
            outputView.printError(e);
            return inputTableNumber();
        }

    }

    public int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputPaymentWay() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return Integer.parseInt(scanner.nextLine());
    }
}
