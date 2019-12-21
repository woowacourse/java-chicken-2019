package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    /**
     * 1.주문등록, 2.결제하기, 3.프로그램종료 중 선택하는 기능입니다.
     *
     * @return 해당 번호가 리턴됩니다.
     */
    public static int inputMainFunction() {
        System.out.println("## 원하는 기능을 선택해해주세요");
        return scanner.nextInt();
    }


}
