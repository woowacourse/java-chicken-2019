package domain;

import domain.Category;

import java.util.List;

public class OrderedQuantity {
	private static final int MAX_FOOD_QUANTITY = 99;
	private int foodNumber;
	private int foodQuantity;
	private int price;
	private String name;
	private String category;
	
	OrderedQuantity(int foodNumber, int foodQuantity, String category, int price, String name) {
		this.foodNumber = foodNumber;
		this.foodQuantity = foodQuantity;
		this.category = category;
		this.price = price;
		this.name = name;
	}
	
	public int getFoodNumber() {
		return this.foodNumber;
	}
	
	public boolean isOverQuantity(int newOrderQuantity) {
		return this.foodQuantity + newOrderQuantity > MAX_FOOD_QUANTITY;
	}
	
	public void plusMenuQuantity(int orderMenu, int orderQuantity, int tablenum) {
		this.foodQuantity += orderQuantity;
	}
	
	public int getQuantity() {
		return this.foodQuantity;
	}
	
	public int getTotalPrice() {
		return price * foodQuantity;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getNameAndQuantityAndPrice(List<Menu> menus) {
		return name + " " + foodQuantity + " " + (price * foodQuantity);
	}
}
