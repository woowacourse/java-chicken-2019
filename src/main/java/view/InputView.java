package view;

import java.util.Scanner;

import domain.FunctionNumber;
import domain.Table;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static FunctionNumber inputFunctionNumber() {
		try {
			System.out.println("###원하는 기능을 선택하세요.");
			FunctionNumber functionNumber = new FunctionNumber(scanner.nextLine());
			return functionNumber;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return inputFunctionNumber();
		}
    }

    public static int inputTableNumber() {
		try {
			System.out.println("## 주문할 테이블을 선택하세요.");
			return Integer.parseInt(scanner.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return inputTableNumber();
		}
    }
}
