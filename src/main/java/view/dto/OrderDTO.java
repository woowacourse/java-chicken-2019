package view.dto;

import domain.Order;

public class OrderDTO {
    private static final String BLANK = " ";
    private final String name;
    private final int amount;
    private final int price;

    private OrderDTO(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public static OrderDTO from(Order order) {
        return new OrderDTO(order.getName(), order.getAmount(), order.getPrice());
    }

    @Override
    public String toString() {
        return name + BLANK + amount + BLANK + price;
    }
}
