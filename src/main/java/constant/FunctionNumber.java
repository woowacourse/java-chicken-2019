package constant;

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
