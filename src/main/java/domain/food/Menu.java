package domain.food;

import domain.purchase.Cost;

public class Menu {
	private final int number;
	private final String name;
	private final Category category;
	private final int price;

	public Menu(final int number, final String name, final Category category, final int price) {
		this.number = number;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public boolean isRightNumber(int menuNumber) {
		return number == menuNumber;
	}

	public Cost calculateCost(int quantity) {
		return new Cost(price * quantity);
	}

	@Override
	public String toString() {
		return category + " " + number + " - " + name + " : " + price + "원";
	}

	public boolean isChicken() {
		return category.isChicken();
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
