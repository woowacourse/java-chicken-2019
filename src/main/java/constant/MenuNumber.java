package constant;

public enum MenuNumber {

	One("1"), Two("2"), Three("3");

	private String number;

	MenuNumber(String number) {
		this.number = number;
	}

	public String getValue() {
		return this.number;
	}

}
