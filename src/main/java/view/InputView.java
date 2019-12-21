package view;

import domain.Table;
import domain.TableRepository;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMainOption() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int tableChecker(List<Table> tableList) {
        int tableNumber = inputTableNumber();
        if (tableList.stream().anyMatch(x -> x.getNumber() == tableNumber)) {
            return tableNumber;
        }
        return tableChecker(tableList);
    }

    public static int inputAddMenu() {
        System.out.println("## 등록할 메뉴를 선택해주세요.");
        return scanner.nextInt();
    }

    public static int inputCountMenu() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
}
