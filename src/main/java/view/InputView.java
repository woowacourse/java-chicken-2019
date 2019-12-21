package view;

import domain.MenuRepository;
import domain.TableRepository;
import viewSupporter.NumberInBounds;
import viewSupporter.NumberList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAIN_MENU = 3;
    private static final List<Integer> TABLE_NUMBERS = TableRepository.tableNumbers();
    private static final List<Integer> MENU_NUMBER = MenuRepository.menuNumbers();
    private static final int QUANTITY = 99;
    private static final int PAYMENT_TYPE = 2;

    public static int inputMainMenuNumber() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String printErrorMessage = "\n## 원하는 기능을 기능 번호로 다시 선택해주세요.";
        List<Integer> mainMenuNumber = NumberList.createNumberList(MAIN_MENU);
        return inputNumber(printErrorMessage, mainMenuNumber);
    }

    public static int inputTableNumber() {
        System.out.println("\n## 테이블을 선택하세요.");
        String printErrorMessage = "\n## 테이블을 테이블 번호로 다시 선택해주세요.";
        return inputNumber(printErrorMessage, TABLE_NUMBERS);
    }

    public static int inputMenuNumber() {
        System.out.println("\n## 등록할 메뉴를 선택하세요.");
        String printErrorMessage = "\n## 등록할 메뉴를 주문할 메뉴 번호로 다시 선택해주세요.";
        return inputNumber(printErrorMessage, MENU_NUMBER);
    }

    public static int inputQuantityNumber() {
        System.out.println("\n## 메뉴의 수량을 입력하세요.");
        String printErrorMessage = "\n## 메뉴의 수량은 (숫자로) 1 ~ " + QUANTITY + "까지 입력 가능합니다.";
        List<Integer> quantityNumber = NumberList.createNumberList(QUANTITY);
        return inputNumber(printErrorMessage, quantityNumber);
    }

    public static int inputPaymentTypeNumber(int tableNumber) {
        System.out.println("\n## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용카드는 1번, 현금은 2번");
        String printErrorMessage = "\n## 결제 유형을 신용카드 - 1, 현금 - 2로 다시 (숫자로만) 선택해주세요.";
        List<Integer> paymentTypeNumber = NumberList.createNumberList(PAYMENT_TYPE);
        return inputNumber(printErrorMessage, paymentTypeNumber);
    }

    private static int inputNumber(String printErrorMessage, List<Integer> numberBounds) {
        String tableNumberString = scanner.nextLine().trim();
        while (!NumberInBounds.isBoundsNumberTF(tableNumberString, numberBounds)) {
            System.out.println(printErrorMessage);
            tableNumberString = scanner.nextLine().trim();
        }
        int tableNumber = Integer.parseInt(tableNumberString);
        return tableNumber;
    }
}
