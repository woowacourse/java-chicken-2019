package view;

import domain.Menu;
import domain.Table;
import exceptions.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInputOfMainUI() {
        System.out.println("원하시는 기능을 입력해주세요.(1-3)");
        String inputOfMainUI = scanner.nextLine();
        try {
            Validator.checkInputOfMainUI(inputOfMainUI);
            return Integer.parseInt(inputOfMainUI);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputOfMainUI();
        }
    }

    public static int getInputOfTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String inputOfTableNumber = scanner.nextLine();
        try {
            Validator.checkInputOfTableNumber(inputOfTableNumber);
            return Integer.parseInt(inputOfTableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputOfTableNumber();
        }
    }

    public static int getInputOfMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String inputOfMenuNumber = scanner.nextLine();
        try {
            Validator.checkInputOfMenuNumber(inputOfMenuNumber);
            return Integer.parseInt(inputOfMenuNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputOfMenuNumber();
        }
    }

    public static int getInputOfMenuQuantity(Table table, Menu menu) {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String inputOfMenuQuantity = scanner.nextLine();
        try {
            Validator.checkInputOfMenuQuantity(inputOfMenuQuantity);
            Validator.checkQuantityExceed(table, menu, Integer.parseInt(inputOfMenuQuantity));
            return Integer.parseInt(inputOfMenuQuantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputOfMenuQuantity(table, menu);
        }
    }
}
