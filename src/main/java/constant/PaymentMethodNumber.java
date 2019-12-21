package constant;

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
