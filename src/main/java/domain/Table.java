package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private static final int QUANTITY_IS_ZERO_AT_FIRST = 0;
	private static final int NO_QUANTITY = 0;
    private final int number;
    private List<OrderedQuantity> orderedQuantities = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
        for (Menu menu : MenuRepository.menus()) {
        	orderedQuantities.add(new OrderedQuantity(menu.getFoodNumber(), QUANTITY_IS_ZERO_AT_FIRST));
        }
    }
    
    public boolean isPresentTable(int tableNum) {
    	return this.number == tableNum;
    }
    
    public boolean isOverQuantity(int newOrderQuantity) {
    	boolean status = false;
    	for (OrderedQuantity orderedQuantity : orderedQuantities) {
    		if (this.number == orderedQuantity.getFoodNumber()) {
    			status = status || orderedQuantity.isOverQuantity(newOrderQuantity);
    		}
    	}
    	return status;
    }
    
    public void registerMenuQuantity(int orderMenu, int orderQuantity, int tablenum) {
    	for (OrderedQuantity orderedQuantity : orderedQuantities) {
    		if (orderedQuantity.getFoodNumber() == orderMenu) {
    			orderedQuantity.plusMenuQuantity(orderMenu, orderQuantity, tablenum);
    		}
    	}
    }
    
    public int getTableNumber() {
    	return this.number;
    }
    
    public int isOrderedTable() {
    	if (orderedQuantities.stream()
				.mapToInt(OrderedQuantity::getQuantity)
				.sum() > NO_QUANTITY) {
    		return this.number;
    	}
    	return -1;
    }
    
    public List<String> printOrderList(List<Menu> menus) {
    	List<String> orderList = new ArrayList<>();
    	for (OrderedQuantity orderedQuantity : orderedQuantities) {
    		if (orderedQuantity.getQuantity() == NO_QUANTITY) {
    			continue;
    		} else if (orderedQuantity.getQuantity() > NO_QUANTITY) {
    			orderList.add(orderedQuantity.getNameAndQuantityAndPrice(menus));
    		}
    	}
    	return orderList;
    }

    @Override
    public String toString() {
		return Integer.toString(number);
	}
}
