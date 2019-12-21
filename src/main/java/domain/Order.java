package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order implements OrderService {
    private Map<Menu, Integer> order;

    public Order() {
        this.order = new HashMap<>();
        for (Menu menu : MenuRepository.menus()) {
            this.order.put(menu, 0);
        }
    }

    public int getTotalCost() {
        int total = 0;
        for (Menu menu : order.keySet()) {
            total += order.get(menu) * menu.getPrice();
        }
        return total;
    }

    public int getChickenQuantity() {
        int total = 0;
        for (Menu menu : filteredChickenMenu()) {
            total += order.get(menu);
        }
        return total;
    }

    private List<Menu> filteredChickenMenu() {
        return order.keySet().stream().filter(Menu::isChicken).collect(Collectors.toList());
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
