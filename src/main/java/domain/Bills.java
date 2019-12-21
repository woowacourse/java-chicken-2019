package domain;

import java.util.HashMap;
import java.util.Map;

public class Bills {
    private final Map<Menu, Integer> bills = new HashMap<>();

    public void add(Menu menu, int quantity) {
        if (bills.containsKey(menu)) {
            validateQuantity(menu, quantity);
            bills.replace(menu, bills.get(menu) + quantity);
            return;
        }
        bills.put(menu, quantity);
    }

    private void validateQuantity(Menu menu, int quantity) {
        if (bills.get(menu) + quantity > 99 ) {
            throw new IllegalArgumentException("최대 수량 99개를 초과하였습니다.");
        }

        if (quantity < 1) {
            throw new IllegalArgumentException("1개 이상부터 주문이 가능합니다.");
        }
    }

    public boolean isEmpty() {
        return bills.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("메뉴 수량 금액\n");
        for (Map.Entry<Menu, Integer> entry : bills.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            builder.append(menu.getName() + " " + quantity + " " + (menu.getPrice() * quantity) +"\n");
        }
        return builder.toString();
    }
}
