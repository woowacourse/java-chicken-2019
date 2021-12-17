package domain;

import utils.validator.MenuCountValidator;

public class MenuState {
	public Menu menu;
	private int count;

	public MenuState(Menu menu, int count) {
		this.menu = menu;
		addCount(count);
		this.count = count;
	}

	@Override
	public String toString() {
		return "MenuState{" + "menu=" + menu + ", count=" + count + '}';
	}

	public void addCount(int count) {
		new MenuCountValidator(this.count + count);
		this.count += count;
	}
}
