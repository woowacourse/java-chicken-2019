package domain;

public class Order {
	private int menuNum;
	private int amount;
	
	public Order(int menuNum, int amount) {
		this.menuNum = menuNum;
		this.amount = amount;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
	public boolean isSameMenu(int menuNum) {
		if (this.menuNum == menuNum) {
			return true;
		}
		return false;
	}
	
	public int getNum() {
		return this.menuNum;
	}
	
	public int getAmount() {
		return this.amount;
	}
}
