package domain;

import java.util.HashMap;
import java.util.Map;

public class Table  extends StoreTool{
    private final Map<Menu, Integer> orderMenus = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrder(Menu menu, int quantity) {
        if (orderMenus.containsKey(menu)) {
            validateQuantity(menu, quantity);
            orderMenus.replace(menu, orderMenus.get(menu) + quantity);
            return;
        }
        orderMenus.put(menu, quantity);
    }


    private void validateQuantity(Menu menu, int quantity) {
        if (orderMenus.get(menu) + quantity > 99 ) {
            throw new IllegalArgumentException("최대 수량 99개를 초과하였습니다.");
        }

        if (quantity < 1) {
            throw new IllegalArgumentException("1개 이상부터 주문이 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
