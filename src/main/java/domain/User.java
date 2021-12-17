package domain;

import java.util.ArrayList;

import domain.repository.MenuRepository;
import utils.Constants;

public class User {
	private final ArrayList<MenuState> menus = new ArrayList<>();

	public User(int menuNum, int menuCount) {
		this.menus.add(new MenuState(MenuRepository.getMenuByNum(menuNum), menuCount));
	}

	public void addMenu(int menuNum, int menuCount) {
		if (menus.stream().noneMatch(menuState -> menuState.menu.getNumber() == menuNum)) {
			menus.add(new MenuState(MenuRepository.getMenuByNum(menuNum), menuCount));
			return;
		}
		MenuState state = menus.stream()
			.filter(menuState -> menuState.menu.getNumber() == menuNum)
			.findFirst()
			.orElse(null);
		assert state != null;
		state.addCount(menuCount);
	}

	public String[] getMenus() {
		return menus.stream().map(MenuState::toString).toArray(String[]::new);
	}

	public int getNoDiscountPay() {
		return menus.stream()
			.filter(menuState -> menuState.menu.getCategory().equals(Category.CHICKEN))
			.mapToInt(menuState -> menuState.menu.getPrice() * menuState.getCount()
				- (menuState.getCount() / Constants.DIVIDER) * Constants.DISCOUNT_MONEY_UNIT)
			.sum()
			+ menus.stream()
			.filter(menuState -> menuState.menu.getCategory().equals(Category.BEVERAGE))
			.mapToInt(menuState -> menuState.menu.getPrice() * menuState.getCount())
			.sum();
	}
}
