package domain;

public class FunctionNumber {
	private final int getOrder = 1;
	private final int payment = 2;
	private final int exit = 3;
	private final int value;
	
	public FunctionNumber(final int value) {
		this.value = value;
		if (this.value != getOrder && this.value != payment && this.value != exit) {
			throw new IllegalArgumentException("입력 번호는 1, 2, 3만 가능합니다.");
		}
	}
	
	public boolean isOne() {
		return value == getOrder;
	}
	
	public boolean isTwo() {
		return value == payment;
	}
	
	public boolean isThree() {
		return value == exit;
	}
}
