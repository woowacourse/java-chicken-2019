/*
 * @(#)Table.java       0.3 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain;

import domain.menu.Menu;
import domain.menu.MenuQuantity;

import java.util.HashMap;

public class Table {
    private final int number;
    private boolean paymentStatus;

    private HashMap<Menu, MenuQuantity> menuStatus = new HashMap<>();

    public Table(final int number) {
        this.number = number;
        this.paymentStatus = true;
    }

    public void addOrderMenu(Menu menu, int menuCount) {
        setPaymentStatus();
        if (menuStatus.containsKey(menu)) {
            menuStatus.put(menu, menuStatus.get(menu).addMenuQuantity(menuCount));
            return;
        }
        menuStatus.put(menu, new MenuQuantity(menuCount));
    }

    private void setPaymentStatus() {
        paymentStatus = false;
    }

    public boolean isSelectedTable(int tableNumber) {
        return this.number == tableNumber;
    }

    public boolean isPaymentCompleted() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
