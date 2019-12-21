package domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    final static List<Order> orderList = new ArrayList<>();

    public static void addList() {

    }

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
        return orderList.stream()
                .mapToInt(order -> order.getMenuPriceByCount())
                .sum();
    }

    public static String showOrderList() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orderList) {
            sb.append(order + "\n");
        }
        return sb.toString();
    }

}
