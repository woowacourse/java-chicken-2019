package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {
    private final int number;
    private TableStatus tableStatus;

    private Map<Menu, Integer> menus = new LinkedHashMap<>();

    public Table(final int number) {
        this.number = number;
        tableStatus = TableStatus.Wating;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    //todo: do other logic
    public void takeOrder(Menu menu) {
        tableStatus = TableStatus.Registered;
        addMenu(menu);
    }

    public int calculateMenuSize() {
        int size = 0;
        for (Menu menu : menus.keySet()) {
            size += menus.get(menu);
        }
        return size;
    }

    //todo: do other logic
    public void getSettled() {
        tableStatus = TableStatus.Wating;
    }

    private void addMenu(Menu menu) {
        //todo: validation
        if (menus.get(menu) != null) {
            menus.put(menu, menus.get(menu) + 1);
            return;
        }

        menus.put(menu, 1);


    }

    public boolean isTarget(int tableNumber) {
        return number == tableNumber;
    }


    public int getNumber() {
        return number;
    }

    public double settle(int wayToPay) {
        double moneyToPay = 0;
        for (Menu menu : menus.keySet()) {
            moneyToPay += menu.getPrice() * menus.get(menu);
        }


        int menuSize = calculateMenuSize();
        int numToDiscount = menuSize / 10;
        for (int i = 0; i < numToDiscount; i++) {
            moneyToPay -= MenuConfig.DISCOUNT_AMOUNT;
        }

        if (wayToPay == WayToPay.cash.getValue()) {
            moneyToPay *= 0.95;
        }

        return moneyToPay;
    }

    public Map<Menu, Integer> getMenus() {
        return menus;
    }

    public boolean isRegistered() {
        return tableStatus.equals(TableStatus.Registered);
    }
}
