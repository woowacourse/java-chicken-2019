package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> menu = new HashMap<Menu, Integer>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
    public int getTableNum() {
    	return this.number;
    }
    
    public boolean isSame(int input) {
    	return this.number == input;
    }
    
    public void addMenu(Menu selectedMenu, int quantity) {
    	this.menu.put(selectedMenu, +quantity);
    }
}
