/*
 * @(#)Table.java       0.5 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.table;

import domain.Payment.OrderAmount;
import domain.Payment.PaymentMethod;
import domain.menu.Menu;
import domain.menu.MenuQuantity;

import java.util.HashMap;

public class Table {
    private final int number;
    private boolean paymentStatus;

    private HashMap<Menu, MenuQuantity> menuStatus = new HashMap<>();
    private OrderAmount orderAmount = OrderAmount.ZERO;

    public Table(final int number) {
        this.number = number;
        this.paymentStatus = true;
    }

    public void addOrderMenu(Menu menu, int menuCount) {
        setNonCompletePayment();

        if (menuStatus.containsKey(menu)) {
            menuStatus.put(menu, menuStatus.get(menu).addMenuQuantity(menuCount));
            orderAmount = addOrderedAmount(menu, menuCount);
            return;
        }
        menuStatus.put(menu, new MenuQuantity(menuCount));
        orderAmount = addOrderedAmount(menu, menuCount);
    }

    private void setNonCompletePayment() {
        paymentStatus = false;
    }

    private OrderAmount addOrderedAmount(Menu menu, int menuCount) {
        return orderAmount.add(menuCount * menu.getPrice());
    }

    public boolean isSelectedTable(int tableNumber) {
        return this.number == tableNumber;
    }

    public boolean isPaymentCompleted() {
        return paymentStatus;
    }

    public double getOrderAmount(int chickenAmount, PaymentMethod paymentMethod) {
        return orderAmount.getOrderAmount(chickenAmount, paymentMethod);
    }

    public HashMap<Menu, MenuQuantity> getMenuStatus() {
        return menuStatus;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void resetTable() {
        orderAmount = OrderAmount.ZERO;
        paymentStatus = true;
        menuStatus = new HashMap<>();
    }
}
