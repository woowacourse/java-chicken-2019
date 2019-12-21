package domain;

import view.dto.PaymentPolicyDTO;

public class Table {
    private final int number;

    private Orders orders = Orders.emptyOrders();

    public Table(final int number) {
        this.number = number;
    }

    public boolean equalId(int id) {
        return number == id;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public boolean hasNotOrders() {
        return orders.isEmpty();
    }

    public void clear() {
        this.orders.clear();
    }

    public Orders getOrders() {
        return this.orders;
    }

    public int getNumber() {
        return number;
    }

    public Payment toPayment(PaymentPolicyDTO paymentPolicyDTO) {
        return new Payment(orders, paymentPolicyDTO.toEntity());
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
