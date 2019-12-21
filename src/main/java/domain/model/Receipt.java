package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private static final String RECEIPT_TITLE = "주문내역\n메뉴, 수량, 금액";
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Menu menu, int conut) {
        orderList.add(new Order(menu, conut));
    }

    public int getTotalPrice() {
        return orderList.stream().mapToInt(Order::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(RECEIPT_TITLE);
        for (Order order : orderList) {
            builder.append(order.toString()).append("\n");
        }
        return builder.toString();
    }
}
