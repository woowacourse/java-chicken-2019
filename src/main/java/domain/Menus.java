package domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private static final int MAX_MENU_QUANTITY = 99;

    private final List<Menu> menus;

    public Menus(Menu menu, int menuQuantity) {
        if (menuQuantity > MAX_MENU_QUANTITY) {
            throw new IllegalArgumentException("한 메뉴의 최대 수량은 99개입니다.");
        }
        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i < menuQuantity; i++) {
            menus.add(menu);
        }
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
