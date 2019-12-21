package domain;

import domain.MenuRepository;

import java.util.List;
import java.util.ArrayList;

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
	
	public void plusMenuQuantity(int orderMenu, int orderQuantity, int tablenum) {
		this.foodQuantity += orderQuantity;
	}
	
	public int getQuantity() {
		return this.foodQuantity;
	}
	
	public String getNameAndQuantityAndPrice(List<Menu> menus) {
		String name = "";
		int price = 0;
		for (Menu menu : MenuRepository.menus()) {
			if (menu.getFoodNumber() == foodNumber) {
				name = menu.getName();
				price = menu.getPrice();
			}
		}
		return name + " " + foodQuantity + " " + price;
	}
}
