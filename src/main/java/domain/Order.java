/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

public class Order extends MenuRepository {
    private Menu menu;
    private Quantity quantity;

    public Order(Menu inputMenu, Quantity inputQuantity) {
        menu = inputMenu;
        quantity = inputQuantity;
    }

    public int getOrderNumber() {
        return menu.getNumber();
    }

    public String getOrderName() {
        return menu.getName();
    }

    public int getQuantity() {
        return this.quantity.getQuantity();
    }

    public void addQuantity(int addedQuantity) {
        this.quantity.addQuantity(addedQuantity);
    }

    public boolean isSameOrder(Order inputOrder) {
        return menu.getNumber() == inputOrder.menu.getNumber();
    }

}
