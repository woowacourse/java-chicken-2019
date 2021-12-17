package domain;

import java.util.ArrayList;
import java.util.stream.Stream;

import domain.repository.MenuRepository;

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
			.filter(menuState -> menuState.menu.getNumber() < 20)
			.mapToInt(menuState -> menuState.menu.getPrice() * menuState.getCount()
				- (menuState.getCount() / 10) * 10000)
			.sum()
			+ menus.stream()
			.filter(menuState -> menuState.menu.getNumber() >= 20)
			.mapToInt(menuState -> menuState.menu.getPrice() * menuState.getCount())
			.sum();
	}

	@Override
	public String toString() {
		return "user-" + menus;
	}
}
