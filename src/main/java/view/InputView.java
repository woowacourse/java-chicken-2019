package view;

import java.util.Scanner;
import Controller.SelectControl;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
	System.out.println("## 주문할 테이블을 선택하세요.");
	
	return scanner.nextInt();
        
        
    }
    
    public static int inputFuction() {
	int tmpNum;
	System.out.println("## 원하는 기능을 선택하세요.");
	tmpNum=SelectControl.checkFunctionSelect(scanner.nextLine());
	while(tmpNum==-1) {
	    tmpNum=SelectControl.checkFunctionSelect(scanner.nextLine());
	}
	return tmpNum;
    }
   
}
