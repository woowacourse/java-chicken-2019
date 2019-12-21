package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	
	private enum Menu {
		One("1"),
		Two("2"),
		Three("3");
		
		private String number;
		
		Menu(String number) {
			this.number = number;
		}
		
		public String getValue() {
			return this.number;
		}
	}

	public static void showMainView() {
		System.out.println("## 메인 화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료\r\n");
		inputFunctionNumber();
	}

	public static void inputFunctionNumber() {
		try {
			System.out.println("## 원하는 기능을 선택해주세요.");
			String number = scanner.next();
			checkValidationNumber(number);
			selectFunction(Integer.parseInt(number));
		} catch (RuntimeException e) {
			inputFunctionNumber();
		}
	}
	
	private static void checkValidationNumber(String number) {
		checkLength(number.length());
		checkIsNumber(number);
	}
	
	private static void checkLength(int length) {
		if (length != 1) {
			System.out.println("기능을 다시 선택해 주세요.");
			throw new RuntimeException();
		}
	}
	
	private static void checkIsNumber(String number) {
		if (!(number.equals(Menu.One.getValue()) || number.equals(Menu.Two.getValue()) 
				|| number.equals(Menu.Three.getValue()))) {
			System.out.println("1 또는 2 또는 3을 입력해 주세요.");
			throw new RuntimeException();
		}
	}

	public static void selectFunction(int number) {
		
	}

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return scanner.nextInt();
	}
}
