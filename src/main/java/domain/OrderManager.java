package domain;

import domain.model.Order;
import domain.model.Receipt;
import view.OutputView;

/**
 * 하나의 주문 전체를 관리하는 클래스
 */
public class OrderManager {
    private TableManager tableManager = new TableManager();
    private OrderCreator orderCreator = new OrderCreator();
    private PayManager payManager = new PayManager();
    private Receipt receipt = null;

    public void startOrder() {
        if (receipt == null) {
            int tableNumber = tableManager.selectTable();
            receipt = new Receipt(tableNumber);
        }
        addNewOrder();
    }

    private void addNewOrder() {
        Order order = orderCreator.makeOrder();
        receipt.addOrder(order);
    }

    public void processPayment() {
        if (receipt != null) {
            OutputView.printOrder(receipt);
            OutputView.printStartPayment(receipt.getTableNumber());
            boolean isSuccess = payManager.processPayment(receipt);
            if (isSuccess) {
                reset();
            }
            return;
        }
        OutputView.printNoOrder();
    }

    private void reset() {
        receipt = null;
    }
}
