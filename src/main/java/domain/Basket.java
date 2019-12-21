package domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static final String NEW_LINE = "\n";
    private static final int DISCOUNT_UNIT_COUNT = 10;
    private static final int DISCOUNT_UNIT_MONEY = 10000;

    final static List<Order> orderList = new ArrayList<>();

    public static void addToOrderList(Menu menu, int foodCount) {
        if (orderList.stream().anyMatch(order -> order.isEqualMenu(menu))) {
            orderList.stream()
                    .filter(order -> order.isEqualMenu(menu))
                    .findAny()
                    .get()
                    .increaseFoodCount(foodCount);
            return;
        }
        orderList.add(new Order(menu, foodCount));
    }

    public static int calculateTotalPrice() {
        int totalPrice = orderList.stream()
                .mapToInt(order -> order.getMenuPriceByCount())
                .sum();
        return discountWhenChickenCategory(totalPrice);
    }

    private static int discountWhenChickenCategory(int totalPrice) {
        int totalCountOfChicken = orderList.stream()
                .mapToInt(order -> order.getFoodCountWhenChicken()).sum();
        return totalPrice - (totalCountOfChicken / DISCOUNT_UNIT_COUNT) * DISCOUNT_UNIT_MONEY;
    }

    public static String showOrderList() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orderList) {
            sb.append(order + NEW_LINE);
        }
        return sb.toString();
    }

}
