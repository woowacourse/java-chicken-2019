package view;

import java.util.Scanner;

import domain.PaymentType;
import domain.PosMenuType;
import domain.Table;

/**
 * 콘솔 입력을 담당하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public class InputView {
    private static final String MENU_SELECT_GUIDE_MESSAGE =
            "## 메인화면\n1: 주문등록\n2: 결제하기\n3: 프로그램 종료\n";
    private static final String TRY_SELECT_GUIDE_MESSAGE = "## 원하시는 기능을 선택하세요.";
    private static final String INVALID_INPUT_MESSAGE = "## 잘못된 입력입니다. 다시 입력해주세요";
    private static final String CREDIT_OR_CASH_GUIDE_MESSAGE = "## 신용카드는 1번, 현금은 2번";
    private static final String SELECT_TABLE_GUIDE_MESSAGE = "## 주문할 테이블을 선택하세요.";
    private static final String ADD_MENU_GUIDE_MESSAGE = "## 등록할 메뉴를 선택하세요.";
    private static final String MENU_PURCHASE_COUNT_GUIDE_MESSAGE = "## 메뉴의 수량을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

	// 묵시적 생성자 방지
    private InputView() {}

    public static PosMenuType inputPosMenu() {
        System.out.println(MENU_SELECT_GUIDE_MESSAGE);
        try {
            System.out.println(TRY_SELECT_GUIDE_MESSAGE);
            String input = scanner.nextLine();
            return PosMenuType.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return inputPosMenu();
        }
    }

    public static PaymentType inputPaymentType(Table table) {
        System.out.println("## " + table.getNumber() + "번 테이블의 결제를 진행합니다.");
        try {
            System.out.println(CREDIT_OR_CASH_GUIDE_MESSAGE);
            String input = scanner.nextLine();
            return PaymentType.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return inputPaymentType(table);
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println(SELECT_TABLE_GUIDE_MESSAGE);
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println(ADD_MENU_GUIDE_MESSAGE);
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return inputMenuNumber();
        }
    }

    public static int inputPurchaseCount() {
        try {
            System.out.println(MENU_PURCHASE_COUNT_GUIDE_MESSAGE);
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return inputPurchaseCount();
        }
    }
}
