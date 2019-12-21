package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;

	public Table(final int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	private HashMap<Integer, Integer> orderMap;

	private Map<Integer, Integer> getOrderMap() {
		if (orderMap == null) {
			orderMap = new HashMap<>();
			return orderMap;
		}
		return orderMap;
	}

	public int getOrderQuantity(int menuChoice) {
		Integer value = getOrderMap().get(menuChoice);
		if (value == null) {
			return 0;
		}
		return value;
	}

	public void putOrder(int menuChoice, int menuQuantity) {
		Integer value = getOrderMap().get(menuChoice);
		if (value == null) {
			getOrderMap().put(menuChoice, menuQuantity);
			return;
		}
		getOrderMap().put(menuChoice, value + menuQuantity);
	}
}
