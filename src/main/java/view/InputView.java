package view;

import domain.TableRepository;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return tableNumber();
    }

    private static int tableNumber() {
        String tableNumberString = "";
        do {
            tableNumberString = scanner.nextLine().trim();
        } while (!isTableNumberTF(tableNumberString));
        int tableNumber = Integer.parseInt(tableNumberString);
        return tableNumber;
    }

    private static boolean isTableNumberTF(String tableNumberString) {
        if (isNumbersTF(tableNumberString)
                && Integer.parseInt(tableNumberString) <= TableRepository.tableNumbers()
                && Integer.parseInt(tableNumberString) > 0) {
            return true;
        }
        System.out.println("## 주문할 테이블을 테이블 번호로 다시 선택해주세요.");
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
