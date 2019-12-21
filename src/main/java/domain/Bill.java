package domain;

import java.util.HashMap;
import java.util.Map;

public class Bill {
    private Table table;
    private Map<Menu, Integer> orders = new HashMap<Menu, Integer>();

    public Bill(Table table) {
        this.table = table;
    }

    public void addOrder(Menu menu, Integer quantity) {
        orders.put(menu, quantity);
    }
}
