package view;

import domain.MenuRepository;
import domain.TableRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAIN_MENU = 3;
    private static final List<Integer> TABLE_NUMBERS = TableRepository.tableNumbers();
    private static final List<Integer> MENU_NUMBER = MenuRepository.menuNumbers();
    private static final int QUANTITY = 99;

    public static int inputMainMenuNumber() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String printErrorMessage = "\n## 원하는 기능을 기능 번호로 다시 선택해주세요.";
        List<Integer> mainMenuNumber = createNumberList(MAIN_MENU);
        return inputNumber(printErrorMessage, mainMenuNumber);
    }

    public static int inputTableNumber() {
        System.out.println("\n## 주문할 테이블을 선택하세요.");
        String printErrorMessage = "\n## 주문할 테이블을 테이블 번호로 다시 선택해주세요.";
        return inputNumber(printErrorMessage, TABLE_NUMBERS);
    }

    public static int inputMenuNumber() {
        System.out.println("\n## 등록할 메뉴를 선택하세요.");
        String printErrorMessage = "\n## 등록할 메뉴를 주문할 메뉴 번호로 다시 선택해주세요.";
        return inputNumber(printErrorMessage, MENU_NUMBER);
    }

    public static int inputQuantityNumber() {
        System.out.println("\n## 메뉴의 수량을 입력하세요.");
        String printErrorMessage = "\n## 메뉴의 수량은 (숫자로) 1 ~ 최대 " + QUANTITY + "까지 입력 가능합니다.";
        List<Integer> quantityNumber = createNumberList(QUANTITY);
        return inputNumber(printErrorMessage, quantityNumber);
    }

    private static List<Integer> createNumberList(int number) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    private static int inputNumber(String printErrorMessage, List<Integer> numberBounds) {
        String tableNumberString = scanner.nextLine().trim();
        while (!isBoundsNumberTF(tableNumberString, numberBounds)) {
            System.out.println(printErrorMessage);
            tableNumberString = scanner.nextLine().trim();
        }
        int tableNumber = Integer.parseInt(tableNumberString);
        return tableNumber;
    }

    private static boolean isBoundsNumberTF(String tableNumberString, List<Integer> numberBounds) {
        if (isNumbersTF(tableNumberString) && numberBounds.contains(Integer.parseInt((tableNumberString)))) {
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
