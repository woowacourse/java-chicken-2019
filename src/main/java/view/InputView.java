package view;

import domain.MenuRepository;
import domain.Table;
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

    public static int inputQuantityNumber(Table orderTable, int menuNumber) {
        int orderCount = orderTable.getOrderMenuCount(menuNumber);
        if (orderCount == QUANTITY) {
            System.out.println("\n## 현재 메뉴의 주문 가능한 개수가 모두 소진되었습니다. 다른 메뉴를 주문하십시오.");
            return 0;
        }
        System.out.println("\n## 메뉴의 수량을 입력하세요.");
        String printErrorMessage = "\n## 한 메뉴당 주문은 " + QUANTITY + "개까지 가능하며, 현재 주문 수량은 " + orderCount + "개로, "
                + (QUANTITY - orderCount) +"개 주문이 가능한 상태입니다. 주문할 메뉴의 수량을 다시 입력하세요." ;
        List<Integer> quantityNumber = NumberList.createNumberList(QUANTITY - orderCount);
        return inputNumber(printErrorMessage, quantityNumber);
    }

    public static int inputPaymentTypeNumber(int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용카드는 1번, 현금은 2번");
        String printErrorMessage = "\n## 결제 유형을 신용카드 - 1, 현금 - 2로 다시 (숫자로만) 선택해주세요.";
        List<Integer> paymentTypeNumber = NumberList.createNumberList(PAYMENT_TYPE);
        return inputNumber(printErrorMessage, paymentTypeNumber);
    }

    private static int inputNumber(String printErrorMessage, List<Integer> numberBounds) {
        String numberString = scanner.nextLine().trim();
        while (!NumberInBounds.isBoundsNumberTF(numberString, numberBounds)) {
            System.out.println(printErrorMessage);
            numberString = scanner.nextLine().trim();
        }
        return Integer.parseInt(numberString);
    }
}
