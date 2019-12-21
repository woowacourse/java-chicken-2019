package domain;

import java.util.HashMap;
import java.util.Map;

public class Bills {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY_PER_MENU = 99;
    private static final int CHICKEN_DISCOUNT_BASE_COUNT = 10;
    private static final int DISCOUNT_AMOUNT_PER_TEN = 10000;

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
        if (bills.get(menu) + quantity > MAX_QUANTITY_PER_MENU ) {
            throw new IllegalArgumentException(menu.getName() + " 최대 수량 99개를 초과하였습니다.");
        }

        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("1개 이상부터 주문이 가능합니다.");
        }
    }

    public int calculateAmount() {
        int chickenCount = 0;
        int sumAmount = 0;

        for (Map.Entry<Menu, Integer> entry : bills.entrySet()) {
            Menu menu = entry.getKey();
            sumAmount += (entry.getValue() * menu.getPrice());
            if (menu.isChicken()) {
                chickenCount += entry.getValue();
            }
        }
        return giveDiscountByChickenCount(sumAmount, chickenCount);
    }

    public int giveDiscountByChickenCount(int amount, int chickenCount) {
        chickenCount /= CHICKEN_DISCOUNT_BASE_COUNT;
        return amount - (DISCOUNT_AMOUNT_PER_TEN * chickenCount);
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
