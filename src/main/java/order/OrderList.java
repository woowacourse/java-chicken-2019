package order;

import domain.Menu;
import except.InputException;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderList {
    private final static int HUNDRED = 100;

    private final HashMap<Menu, Integer> menuCount;

    public OrderList() {
        menuCount = new HashMap<>();
    }

    public boolean addMenu(Menu menu, int count) {
        if (menuCount.containsKey(menu)) {
            if (InputException.overCheck(menuCount.get(menu) + count))
                return false;
            menuCount.put(menu, menuCount.get(menu) + count);
            return true;
        }
        menuCount.put(menu, count);
        return true;
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

    public void vacateOrder() {
        menuCount.clear();
    }

    public boolean isActive() {
        return !menuCount.isEmpty();
    }

}
