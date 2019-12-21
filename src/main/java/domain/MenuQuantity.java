package domain;

import java.util.HashMap;
import java.util.List;


/**
 * 테이블의 메뉴-주문수량을 담당하는 일급 Collection
 */
public class MenuQuantity {
    private static final int ZERO = 0;
    private static final int MAXIMUM_QUANTITY = 99;

    private final HashMap<Menu, Integer> menuQuantity;

    protected MenuQuantity(List<Menu> menus) {
        menuQuantity = new HashMap<>();
        for (Menu menu : menus) {
            menuQuantity.put(menu, ZERO);
        }
    }

    protected Boolean canAddMenuQuantity(Menu menu, int quantity) {
        if (menuQuantity.get(menu) + quantity > MAXIMUM_QUANTITY){
            return false;
        }
        return true;
    }

    protected void addMenuQuantity(Menu menu, int quantity) {
        if (canAddMenuQuantity(menu, quantity)) {
            menuQuantity.put(menu, menuQuantity.get(menu) + quantity);
        }
    }
}
