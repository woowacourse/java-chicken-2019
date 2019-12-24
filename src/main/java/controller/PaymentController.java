package controller;

import domain.Tables;
import view.InputView;
import view.OutputView;

public class PaymentController {
    private Tables tables;

    public PaymentController(Tables tables) {
        this.tables = tables;
    }

    public void run() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        if (!tables.getTable(tableNumber).hasMenu()) {
            OutputView.printMessageNoMenu();
            return;
        }
        OutputView.printOrderList(tables, tableNumber);
        final int paymentMethod = InputView.inputPaymentMethod(tableNumber);
        // TODO 처리할 테이블이 없을 때 처리
        tables.payTableMenu(tableNumber, paymentMethod);
        System.out.println();

    }
}
