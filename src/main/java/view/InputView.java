package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
    	// 범용적으로 테이블 번호만을 입력받도록 설계
        System.out.println("## 테이블을 선택하세요");
        return scanner.nextInt();
    }
    
    public static int inputCommandList() {
    	/* 1 - 주문등록
    	 * 2 - 결제하기
    	 * 3 - 프로그램 종료
    	 */
    	System.out.println("## 원하는 기능을 선택하세요.");
    	return scanner.nextInt();
    }
    
    public static int inputMethodOfPayment(int tableNumber) {
    	/* 1 - 신용카드
    	 * 2 - 현금
    	 */
    	System.out.printf("## %s번 테이블의 결제를 진행합니다\n", tableNumber);
    	System.out.println("## 신용카드는 1번, 현금은 2번.");
    	return scanner.nextInt();
    }
    
    public static int inputMenuType() {
    	System.out.println("## 등록할 메뉴를 선택하세요.");
    	return scanner.nextInt();
    }
    
    public static int inputMenuNumber() {
    	System.out.println("## 메뉴의 수량을 입력하세요.");
    	return scanner.nextInt();
    }
}
