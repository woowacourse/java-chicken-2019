package view;

import java.util.Scanner;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Payment;
import domain.PaymentFactory;
import domain.Table;
import domain.TableRepository;
import util.ValidateUtil;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFunctionId() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            int data = inputInt();
            ValidateUtil.validateFunctionId(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputFunctionId();
        }
    }

    public static Table inputTable() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            int data = inputInt();
            return TableRepository.getTableByNumber(data);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputTable();
        }
    }
    public static Menu inputMenu() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            int data = inputInt();
            return MenuRepository.getMenuByNumber(data);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputMenu();
        }
    }

    public static int inputMenuQuantity() {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            int data = inputInt();
            ValidateUtil.validateMenuQuantity(data);
            return data;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputMenuQuantity();
        }
    }

    public static Payment inputPayment() {
        try {
            System.out.println("## 1번 테이블의 결제를 진행합니다.\n## 신용 카드는 1번, 현금은 2번");
            int code = inputInt();
            return PaymentFactory.getInstance(code);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputPayment();
        }
    }

    private static int inputInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return inputInt();
        }
    }
}
