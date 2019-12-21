package domain;

public class OrderedQuantity {
	private static final int MAX_FOOD_QUANTITY = 99;
	private int foodNumber;
	private int foodQuantity;
	
	OrderedQuantity(int foodNumber, int foodQuantity) {
		this.foodNumber = foodNumber;
		this.foodQuantity = foodQuantity;
	}
	
	public int getFoodNumber() {
		return this.foodNumber;
	}
	
	public boolean isOverQuantity(int newOrderQuantity) {
		return this.foodQuantity + newOrderQuantity > MAX_FOOD_QUANTITY;
	}
	
	public void plusMenuQuantity(int orderMenu, int orderQuantity) {
		this.foodQuantity += orderQuantity;
	}
}
