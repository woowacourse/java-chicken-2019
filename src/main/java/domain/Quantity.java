/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 주문하는 양에 관한 클래스입니다. 원시타입의 포장.
 * @since : 2019.12.23 월요일
 */
public class Quantity {
    private static final int MIN_ORDER_QUANTITY = 1;
    private static final int MAX_ORDER_QUANTITY = 99;

    private int quantity = 0;

    public Quantity() {
    }

    public void putQuantity(int inputQuantity) {
        if (checkOrderQuantity(inputQuantity)) {
            this.quantity = inputQuantity;
            return;
        }
    }

    public static boolean checkOrderQuantity(int inputQuantity) {
        return inputQuantity <= MAX_ORDER_QUANTITY && inputQuantity >= MIN_ORDER_QUANTITY;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int addedQuantity) {
        quantity += addedQuantity;
    }

}
