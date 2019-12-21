package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
	private List<Menu> orderList = new ArrayList<Menu>();

	public void setOrder(Menu menu) {
		orderList.add(menu);
	}
}
