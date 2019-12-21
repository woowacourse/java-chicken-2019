package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private static final String RECEIPT_TITLE = "메뉴, 수량, 금액";
    private List<Order> orderList = new ArrayList<>();
    private int tableNumber;

    public Receipt(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void addOrder(Order order) {
        orderList.add(order);
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

    public boolean hasOrder() {
        return !orderList.isEmpty();
    }
}
