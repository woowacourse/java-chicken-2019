/*
 * @(#)MenuQuantity.java        0.1 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.menu;

public class MenuQuantity {
    private static final int ZERO_MENU_QUANTITY = 0;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 99;

    private final int menuQuantity;

    public static final MenuQuantity ZERO = new MenuQuantity(ZERO_MENU_QUANTITY);

    public MenuQuantity(int menuQuantity) {
        isValid(menuQuantity);
        this.menuQuantity = menuQuantity;
    }

    private void isValid(int menuQuantity) {
        if (menuQuantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("주문 가능한 최대 수량은 99개입니다.");
        }
        if (menuQuantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("주문 가능한 최소 수량은 1개입니다.");
        }
    }

    public MenuQuantity addMenuQuantity(int addMenuQuantity) {
        return new MenuQuantity(menuQuantity + addMenuQuantity);
    }

    public int getMenuQuantity() {
        return menuQuantity;
    }
}
