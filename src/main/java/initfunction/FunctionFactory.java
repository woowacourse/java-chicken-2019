package initfunction;

public class FunctionFactory {
	private final static int ORDER_CODE = 1;
	private final static int PURCHASE_CODE = 2;
	private final static int EXIT_CODE = 3;

	public static ChickenFunction getInstance(int code) {
		if (code == ORDER_CODE) {
			return new OrderFunction();
		}
		if (code == PURCHASE_CODE) {
			return new PurchaseFunction();
		}
		if (code == EXIT_CODE) {
			return new ExitFunction();
		}
		throw new IllegalArgumentException("유효한 값을 입력해주세요.");
	}
}
