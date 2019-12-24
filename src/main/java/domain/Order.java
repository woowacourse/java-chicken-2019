/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 주문에 관한 클래스입니다.
 * @since : 2019.12.23 월요일
 */
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

    public int getPrice() {
        return this.menu.getPrice();
    }

    public boolean isChicken() {
        return menu.isChicken();
    }
}
