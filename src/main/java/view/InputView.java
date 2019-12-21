package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static int inputMethodNumber() {
        System.out.println("## 메인화면\n 1 - 주문등록\n 2 - 결제하기\n 3 - 프로그램종료\n");
        System.out.println("## 원하는기능을선택하세요.");
        String string = scanner.nextLine();
        
        try {
            Validator.validateMethodNumber(string);
        } catch (NumberFormatException e) {
            System.err.println("숫자를 입력해주세요.");
            return inputMethodNumber();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputMethodNumber();
        }
        
        return Integer.valueOf(string);
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String string = scanner.nextLine();
        try {
            Validator.validateTableNumber(string);
        } catch (NumberFormatException e) {
            System.err.println("숫자를 입력해주세요.");
            return inputTableNumber();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputTableNumber();
        }
        
        return Integer.valueOf(string);
    }
    
    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String string = scanner.nextLine();
        try {
            Validator.validateMenuNumber(string);
        } catch (NumberFormatException e) {
            System.err.println("숫자를 입력해주세요.");
            return inputMenuNumber();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputMenuNumber();
        }
        
        return Integer.valueOf(string);
    }
    
    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String string = scanner.nextLine();
        try {
            Validator.validateNull(string);
        } catch (NumberFormatException e) {
            System.err.println("숫자를 입력해주세요.");
            return inputMenuCount();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputMenuCount();
        }
        
        return Integer.valueOf(string);
    }
}
