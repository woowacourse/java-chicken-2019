package constant;

/**
 * 결제 수단을 나타내는 상수
 * @author giantim
 *
 */
public enum PaymentMethodNumber {
	One("1"), Two("2");

	private String number;

	PaymentMethodNumber(String number) {
		this.number = number;
	}

	public String getValue() {
		return this.number;
	}
}
