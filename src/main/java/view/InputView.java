package view;

import domain.TableRepository;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAIN_MENU_NUMBER = 3;
    private static final int TABLE_NUMBERS = TableRepository.tableNumbers();

    public static int inputMainMenuNumber() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String printErrorMessage = "\n## 원하는 기능을 기능 번호로 다시 선택해주세요.";
        return inputNumber(printErrorMessage, MAIN_MENU_NUMBER);
    }

    public static int inputTableNumber() {
        System.out.println("\n## 주문할 테이블을 선택하세요.");
        String printErrorMessage = "\n## 주문할 테이블을 테이블 번호로 다시 선택해주세요.";
        return inputNumber(printErrorMessage, TABLE_NUMBERS);
    }

    private static int inputNumber(String printErrorMessage, int numberBounds) {
        String tableNumberString = scanner.nextLine().trim();
        while (!isBoundsNumberTF(tableNumberString, numberBounds)) {
            System.out.println(printErrorMessage);
            tableNumberString = scanner.nextLine().trim();
        }
        int tableNumber = Integer.parseInt(tableNumberString);
        return tableNumber;
    }

    private static boolean isBoundsNumberTF(String tableNumberString, int numberBounds) {
        if (isNumbersTF(tableNumberString)
                && Integer.parseInt(tableNumberString) <= numberBounds
                && Integer.parseInt(tableNumberString) > 0) {
            return true;
        }
        return false;
    }

    private static boolean isNumbersTF(String numbers) {
        boolean numbersTF = true;
        for (int i = 0; i < numbers.length(); i++) {
            numbersTF = numbersTF && isNumberTF(numbers.charAt(i));
        }
        return numbersTF;
    }

    private static boolean isNumberTF(char number) {
        if (number >= '0' && number <= '9') {
            return true;
        }
        return false;
    }
}
