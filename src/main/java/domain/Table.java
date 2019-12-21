package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	private final int number;
	//private final List<Menu> menus = new ArrayList<Menu>();
	private final Map<Menu, Integer> menus  = new HashMap<Menu,Integer>();

	public Table(final int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public Map<Menu, Integer> getMenus() {
		return this.menus;
	}

	public void add(Menu inputMenu, int menuCount) {
		for(Menu menu : menus) {
			if(menu == inputMenu) {
				
			}
		}
		// 예외처리 필요
	}

	public boolean isEmpty() {
		return this.menus.isEmpty();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

}
