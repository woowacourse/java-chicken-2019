package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int enterApplication() {
		try {
	    	System.out.println("## 메인화면\n" + "1 - 주문등록\n" + "2 - 결제하기\n" + "3 - 프로그램 종료");
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("1,2,3만 입력해주세요");
			return enterApplication();
		}
    }
    
    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
