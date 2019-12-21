package order;

import domain.Menu;

import java.util.HashMap;

public class OrderList {
    private final HashMap<Menu, Integer> menuCount;

    public OrderList() {
        menuCount = new HashMap<>();
    }

    public void addMenu(Menu menu, int count) {
        if (menuCount.containsKey(menu)) {
            menuCount.put(menu, menuCount.get(menu) + count);
            return;
        }
        menuCount.put(menu, count);
    }

    public int getChickenCount() {
        int chickenCount = 0;
        for (Menu menu : menuCount.keySet()) {
            if(menu.isChicken())
                chickenCount += menuCount.get(menu);
        }
        return chickenCount;
    }

    public int getPrice() {
        return 1;
    }
}
