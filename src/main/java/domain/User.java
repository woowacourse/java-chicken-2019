package domain;

import java.util.ArrayList;

import domain.repository.MenuRepository;

public class User {
	private final int tableNum;
	private final ArrayList<MenuState> menus = new ArrayList<>();

	public User(int tableNum, int menuNum, int menuCount) {
		this.tableNum = tableNum;
		this.menus.add(new MenuState(MenuRepository.getMenuByNum(menuNum), menuCount));
	}

	public int getTableNum() {
		return tableNum;
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

	@Override
	public String toString() {
		return "user-테이블" + tableNum + " : " + menus;
	}
}
