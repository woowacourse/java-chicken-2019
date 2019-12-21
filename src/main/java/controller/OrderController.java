package controller;

import domain.Tables;
import view.InputView;
import view.OutputView;

public class OrderController {
    private Tables tables;

    public OrderController(Tables tables) {
        this.tables = tables;
    }

    public void run() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);

    }

}
