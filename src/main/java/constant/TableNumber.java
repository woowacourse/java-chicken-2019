package constant;

/**
 * 테이블 숫자를 나타내는 상수
 * @author giantim
 *
 */
public enum TableNumber {
	
	One("1"), Two("2"), Three("3"), Five("5"),
	Six("6"), Eight("8");
	
	private String tableNumber;
	
	TableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public String getValue() {
		return this.tableNumber;
	}
}
