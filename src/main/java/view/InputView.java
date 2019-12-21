package view;

import Check.Check;
import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber(final List<Table> tables) {
        System.out.println("\n## 테이블을 선택하세요.");
        String userInput = scanner.next();
        while (new Check().isInputTableError(userInput,tables)){
            userInput = scanner.next();
        }
        return Integer.parseInt(userInput);
    }

    public int inputFunction() {
        System.out.println("\n원하는 기능을 입력하세요.");
        String userInput = scanner.next();
        while (new Check().isInputFunctionError(userInput)) {
            userInput = scanner.next();
        }
        return Integer.parseInt(userInput);
    }

    public int[] inputMenu(final List<Menu> menus){
        int[] order = new int[]{inputMenuNumber(menus),inputMenuCount()};
        return order;
    }

    public int inputMenuNumber(final List<Menu> menus){
        System.out.println("등록할 메뉴를 선택하세요");
        String userInput = scanner.next();
        while (new Check().isInputMenuNumberError(userInput,menus)){
            userInput = scanner.next();
        }
        return Integer.parseInt(userInput);
    }

    public int inputMenuCount(){
        System.out.println("메뉴의 수량을 입력하세요");
        String userInput = scanner.next();
        while (new Check().isInputMenuCountError(userInput)){
            userInput = scanner.next();
        }
        return Integer.parseInt(userInput);
    }
}
