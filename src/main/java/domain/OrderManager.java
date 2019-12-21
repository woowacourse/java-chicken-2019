package domain;

import domain.model.Order;
import domain.model.Receipt;
import domain.repository.TableRepository;
import view.OutputView;

import java.util.Arrays;

/**
 * 하나의 주문 전체를 관리하는 클래스
 */
public class OrderManager {
    private TableManager tableManager = new TableManager();
    private OrderCreator orderCreator = new OrderCreator();
    private PayManager payManager = new PayManager();
    private Receipt[] receipts = new Receipt[TableRepository.size()];

    public OrderManager() {
        resetAll();
    }

    public void startOrder() {
        int tableNumber = tableManager.selectTable(true);
        int index = TableRepository.search(tableNumber);
        if (receipts[index] == null) {
            receipts[index] = new Receipt(tableNumber);
        }
        addNewOrder(index);
    }

    private void addNewOrder(int index) {
        Order order = orderCreator.makeOrder();
        receipts[index].addOrder(order);
    }

    public void processPayment() {
        int tableNumber = tableManager.selectTable(false);
        int index = TableRepository.search(tableNumber);
        if (receipts[index] != null) {
            OutputView.printOrder(receipts[index], receipts[index].getTableNumber());
            if (payManager.processPayment(receipts[index])) {
                reset(index);
                return;
            }
        }
        OutputView.printNoOrder();
    }

    private void reset(int index) {
        receipts[index] = null;
        tableManager.clearTable(index);
    }

    private void resetAll() {
        Arrays.fill(receipts, null);
    }
}
