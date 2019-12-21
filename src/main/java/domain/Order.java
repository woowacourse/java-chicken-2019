package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order implements OrderService {
    private static final int ZERO = 0;
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

    private List<Menu> filteredNonZeroMenu() {
        return order.keySet().stream().filter(this::isOrdered).collect(Collectors.toList());
    }

    public boolean isOrderEmpty() {
        return filteredNonZeroMenu().size() == 0;
    }

    private boolean isOrdered(Menu menu) {
        return order.get(menu) != ZERO;
    }

    @Override
    public void changeQuantity(Menu menu, int quantityToAdd) {
        order.put(menu, order.get(menu) + quantityToAdd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Menu menu : filteredNonZeroMenu()) {
            sb.append(menu.getName()).append(" ").append(order.get(menu)).append(" ")
                .append(order.get(menu) * menu.getPrice()).append("\n");
        }
        return sb.toString();
    }
}
