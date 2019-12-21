package view;

import constant.FunctionNumber;
import constant.ProjectConstant;
import constant.TableNumber;
import constant.PaymentMethodNumber;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static void showMainView() {
		System.out.println("## 메인 화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료\r\n");
	}

	public static String inputFunctionNumber() {
		String number = "";

		try {
			System.out.println("## 원하는 기능을 선택해주세요.");
			number = scanner.next();
			checkValidationNumber(number);
			return number;
		} catch (RuntimeException e) {
			number = inputFunctionNumber();
		}
		return number;
	}

	private static void checkValidationNumber(String number) {
		checkLength(number.length());
		checkIsNumber(number);
	}

	private static void checkLength(int length) {
		if (length != 1) {
			System.out.println("다시 선택해 주세요.");
			throw new RuntimeException();
		}
	}

	private static void checkIsNumber(String number) {
		if (!(number.equals(FunctionNumber.One.getValue()) || number.equals(FunctionNumber.Two.getValue())
				|| number.equals(FunctionNumber.Three.getValue()))) {
			System.out.println("1 또는 2 또는 3을 입력해 주세요.");
			throw new RuntimeException();
		}
	}

	public static String inputTableNumber() {
		String tableNumber = "";

		try {
			System.out.println("## 테이블을 선택하세요.");
			tableNumber = scanner.next();
			checkValidationTableNumber(tableNumber);
		} catch (RuntimeException e) {
			tableNumber = inputTableNumber();
		}
		return tableNumber;
	}

	private static void checkValidationTableNumber(String tableNumber) {
		checkLength(tableNumber.length());
		checkIsTableNumber(tableNumber);
	}

	private static void checkIsTableNumber(String tableNumber) {
		boolean check = false;

		for (TableNumber t : TableNumber.values()) {
			if (check == true) {
				break;
			}
			if (t.getValue().equals(tableNumber)) {
				check = true;
			}
		}
		if (check == false) {
			System.out.println("1 ~ 8(4제외) 중에 테이블 번호를 입력해 주세요.");
			throw new RuntimeException();
		}
	}

	public static String inputMenuNumber() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		return scanner.next();
	}

	public static String inputMenuCount() {
		System.out.println("\r\n## 메뉴의 수량을 입력하세요.");
		return scanner.next();
	}

	public static String inputPaymentMethod() {
		String method = ProjectConstant.EMPTY;

		try {
			System.out.println("## 신용 카드는 1번, 현금은 2번");
			method = scanner.next();
			checkMethodValidation(method);
		} catch (RuntimeException e) {
			method = inputPaymentMethod();
		}
		return method;
	}
	
	private static void checkMethodValidation(String method) {
		checkLength(method.length());
		checkIsPaymentMethod(method);
	}
	
	private static void checkIsPaymentMethod(String method) {
		if (!(method.equals(PaymentMethodNumber.One.getValue()) 
				|| method.equals(PaymentMethodNumber.Two.getValue()))) {
			System.out.println("다시 선택해 주세요.");
			throw new RuntimeException();
		}
	}
}
