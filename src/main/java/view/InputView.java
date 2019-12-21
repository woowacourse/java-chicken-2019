package view;

import java.util.Scanner;

import exception.InvalidInputException;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMain() {
        OutputView.printFeatures();
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            int input = validateInputMain(scanner.nextInt());
            OutputView.printBlankLine();
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMain();
        }
    }

    private static int validateInputMain(int input) throws InvalidInputException {
        if (input == 1 || input == 2 || input == 3) {
            return input;
        }
        throw new InvalidInputException("1, 2, 3 중에서 올바르게 입력해주세요.");
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        try {
            int input = validateInputTableNumber(scanner.nextInt());
            OutputView.printBlankLine();
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTableNumber();
        }
    }

    private static int validateInputTableNumber(int input) throws InvalidInputException {
        if (input == 1 || input == 2 || input == 3 || input == 5 || input == 6 || input == 8) {
            return input;
        }
        throw new InvalidInputException("테이블 번호를 올바르게 입력해주세요.");
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        try {
            int input = validateInputMenuNumber(scanner.nextInt());
            OutputView.printBlankLine();
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMenuNumber();
        }
    }

    private static int validateInputMenuNumber(int input) throws InvalidInputException {
        if ((input >= 1 && input <= 6) || input == 21 || input == 22) {
            return input;
        }
        throw new InvalidInputException("메뉴 번호를 올바르게 입력해주세요.");
    }

    public static int inputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        int input = scanner.nextInt();
        OutputView.printBlankLine();
        return input;
    }

    public static int inputPayMethod(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.\n"
            + "## 신용 카드는 1번, 현금은 2번");
        try {
            int input = validateInputPayMethod(scanner.nextInt());
            OutputView.printBlankLine();
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPayMethod(tableNumber);
        }
    }

    private static int validateInputPayMethod(int input) throws InvalidInputException {
        if (input == 1 || input == 2) {
            return input;
        }
        throw new InvalidInputException("1, 2 중에서 올바르게 입력해주세요.");
    }
}
