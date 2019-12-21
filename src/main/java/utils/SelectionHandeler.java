package utils;

import view.InputView;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;

public class SelectionHandeler {
    public static int selectFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        int selectedNumber = selectInt();
        if( selectedNumber != 0 ) {
            return selectedNumber;
        }
        return selectFunction();
    }

    public static int selectTable() {
        System.out.println("## 테이블을 선택하세요.");
        int selectedNumber = selectInt();
        if( selectedNumber != 0 ) {
            return selectedNumber;
        }
        return selectTable();
    }

    public static int selectMenu() {
        System.out.println("## 등록할 메뉴를 입력하세요.");
        int selectedNumber = selectInt();
        if( selectedNumber != 0 ) {
            return selectedNumber;
        }
        return selectMenu();
    }

    public static int selectAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        int selectedNumber = selectInt();
        if( selectedNumber != 0 ) {
            return selectedNumber;
        }
        return selectAmount();
    }

    private static int selectInt() {
        try {
            return InputView.inputSelectNumber();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력해 주세요!");
            InputView.scanNextLine();
            return 0;
        }
    }
}
