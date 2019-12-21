package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Payment {
    public void paymentControl() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        OutputView.printOrders(TableRepository.getOrders(tableNumber));
        OutputView.printPaymentProcessStarted(tableNumber);

        final int cardOrCash = InputView.inputCardOrCash();

        OutputView.printTotalPaymentAmount(pay(tableNumber, cardOrCash));
    }

    /**
     * 결제를 수행하고, 결제가 완료된 테이블의 주문내역을 삭제한다.
     *
     * @return 결제한 총 금액
     */
    private int pay(int tableNum, int paymentMethod) {
        int totalPaymentAmount = TableRepository.getTotalPayment(tableNum);
        TableRepository.deleteAllOrders(tableNum);
        return totalPaymentAmount;
    }
}
