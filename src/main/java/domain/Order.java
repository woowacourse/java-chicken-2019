package domain;

import java.util.HashMap;
import java.util.Map;

public class Order implements OrderService {
    private Map<Menu, Integer> order;

    public Order() {
        this.order = new HashMap<>();
        for (Menu menu : MenuRepository.menus()) {
            this.order.put(menu, 0);
        }
    }

    @Override
    public void changeQuantity(Menu menu, int quantityToAdd) {
        // TODO: 메뉴 개수 관련 예외처리
        order.put(menu, order.get(menu) + quantityToAdd);
    }

    @Override
    public String toString() {
        return "Order{" +
            "order=" + order +
            '}';
    }
}
