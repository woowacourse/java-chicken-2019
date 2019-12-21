package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
	private static List<Menu> orderedMenu = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

	public int getNumber() {
		return number;
	}
	
	public int getOrderCount() {
		return orderedMenu.size();
	}
}
