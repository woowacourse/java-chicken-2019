package domain;

import java.util.Map;

public class Discount {
	private static final double DISCOUNT_CASH = 0.95;
	private static final int DISCOUNT_CHICKEN_MIN_COUNT = 10;
	private static final int DISCOUNT_WON = 10_000;

	public static int discountByCash(int price) {
		return (int) (price * DISCOUNT_CASH);
	}

	public static int discountByChickenCount(int price, Table table) {
		int discountPrice = price; 
		Map<Integer, Integer> menuList = table.getMenuList();
		for (int menuNumber : menuList.keySet()) {
			Menu menu = MenuRepository.getMenu(menuNumber);
			int menuCount = menuList.get(menuNumber);
			if (menu.toString().contains("치킨") && menuCount >= DISCOUNT_CHICKEN_MIN_COUNT) {
				discountPrice -= DISCOUNT_WON * (menuCount / DISCOUNT_CHICKEN_MIN_COUNT);
			}
		}
		return discountPrice;
	}
}
