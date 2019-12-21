package constant;

public enum TableNumber {
	
	One("1"), Two("2"), Three("3"), Five("5"),
	Six("6"), Seven("7"), Eight("8");
	
	private String tableNumber;
	
	TableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public String getValue() {
		return this.tableNumber;
	}
}
