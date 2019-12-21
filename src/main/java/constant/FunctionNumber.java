package constant;

/**
 * 주문, 결제, 종료를 나타내는 상수
 * @author giantim
 *
 */
public enum FunctionNumber {
	
	One("1"), Two("2"), Three("3");

	private String number;

	FunctionNumber(String number) {
		this.number = number;
	}

	public String getValue() {
		return this.number;
	}
}
