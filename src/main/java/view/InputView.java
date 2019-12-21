package view;

import java.util.Scanner;
import java.*;

public final class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문하기");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    return ErrorDetect.mainInputError(scanner.nextInt());

    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return ErrorDetect.tableInputError(scanner.nextInt());
    }
}
