package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void showMainView() {
    	System.out.println("## 메인 화면");
    	System.out.println("1 - 주문등록");
    	System.out.println("2 - 결제하기");
    	System.out.println("3 - 프로그램 종료\r\n");
    }
    
    public static int inputFunctionNumber() {
    	System.out.println("## 원하는 기능을 선택해주세요.");
    	return scanner.nextInt();
    }
    
    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
