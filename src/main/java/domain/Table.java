package domain;

import domain.Menu;

import java.util.ArrayList;

public class Table {
    private final int number;
    
    private class TableMenu {
    	private Menu myMenu;
    	private int menuCount;
    	
    	public TableMenu(Menu menu, int count) {
    		myMenu = menu;
    		menuCount = count;
    	}
    }
    private ArrayList<TableMenu> menuList;

    public Table(final int number) {
        this.number = number;
        this.menuList = new ArrayList<TableMenu>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
    public void addMenu(Menu menu, int menuCount) {
    	menuList.add(new TableMenu(menu, menuCount));
    }
}
