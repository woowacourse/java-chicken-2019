package domain;

public class FunctionNumber {
	public final int charLength = 1;
	public final char getOrder = '1';
	public final char payment = '2';
	public final char exit = '3';
	private final char value;
	
	public FunctionNumber(String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException("입력된 값이 없습니다.");
		}
		if (value.length() > charLength) {
			throw new IllegalArgumentException("입력 문자가 두 자 이상이 될 수 없습니다.");
		}
		
		this.value = Character.toLowerCase(value.charAt(0));
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
