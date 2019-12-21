package order;

import domain.Menu;

import java.util.ArrayList;
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
            if (menu.isChicken())
                chickenCount += menuCount.get(menu);
        }
        return chickenCount;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Menu menu : menuCount.keySet()) {
            totalPrice += menu.getPrice() * menuCount.get(menu);
        }
        return totalPrice;
    }

    public ArrayList<String> orderListToStringArray() {
        ArrayList<String> orders = new ArrayList<>();
        for (Menu menu : menuCount.keySet()) {
            String temp = String.join(" "
                    , menu.getName()
                    , Integer.toString(menuCount.get(menu))
                    , Integer.toString(menuCount.get(menu) * menu.getPrice()));
            orders.add(temp);
        }
        return orders;
    }

    public void vacateOrder(){
        menuCount.clear();
    }

    public boolean isActive(){
        return !menuCount.isEmpty();
    }
}
