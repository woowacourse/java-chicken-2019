package domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private final List<Menu> menus;

    public Menus(Menu menu, int menuQuantity) {
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
