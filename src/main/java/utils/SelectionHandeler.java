package utils;

import view.InputView;

import java.security.InvalidParameterException;

public class SelectionHandeler {
    public static int selectMenu() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return selectInt();
    }

    public static int selectTable() {
        System.out.println("## 테이블을 선택하세요.");
        return selectInt();
    }

    private static int selectInt() {
        try {
            return InputView.inputSelectNumber();
        } catch (InvalidParameterException e ) {
            System.out.println("숫자만 입력해 주세요!");
            return selectMenu();
        }
    }
}
