package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static int enterApplication() {
		try {
			System.out.println("##원하는 기능을 선택하세요");
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
