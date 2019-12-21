package util;

public class ValidateUtil {
	private static final int MIN_FUNCTION_NUMBER = 1;
	private static final int MAX_FUNCTION_NUMBER = 3;
	private static final int MIN_ORDER_QUANTITY = 1;
	private static final int CREDIT_CODE = 1;
	private static final int CASH_CODE = 2;

	public static void validateFunctionId(int data) {
		if (data < MIN_FUNCTION_NUMBER || data > MAX_FUNCTION_NUMBER) {
			throw new IllegalArgumentException("입력 오류");
		}
	}

	public static void validateTableNumber(int data) {

	}

	public static void validateMenuNumber(int data) {

	}

	public static void validateMenuQuantity(int data) {
		if (data < MIN_ORDER_QUANTITY) {
			throw new IllegalArgumentException("주문 수량 입력 오류");
		}
	}

	public static void validatePaymentCode(int data) {
		if (data != CREDIT_CODE && data != CASH_CODE) {
			throw new IllegalArgumentException("결제 코드 입력 오류");
		}
	}
}
