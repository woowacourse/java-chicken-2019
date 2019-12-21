package domain;

import view.InputView;
import view.OutputView;

public class Table {
    private final int number;
    private Bill bill;

    public Table(final int number) {
        this.number = number;
        bill = new Bill();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Integer) {
            Integer number = (Integer) o;
            return this.number == number;
        }
        return false;
    }

    public void addOrder(Order order) {
        bill.updateBill(order);
    }

    public boolean hasOrders() {
        return bill.hasOrders();
    }

    public void showOrders() {
        OutputView.printOrders();
        bill.showOrders();
    }

    public void pay() {
        OutputView.startPayment(number);
        int paymentMethod = InputView.inputPayMethod();
        bill.calTotal(paymentMethod);
        bill = new Bill();
    }
}
