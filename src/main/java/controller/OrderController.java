package controller;

import domain.Table;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderController {
    private Tables tables;

    public OrderController(Tables tables) {
        this.tables = tables;
    }

    public void run() {
        OutputView.printTables((List<Table>) tables);
        final int tableNumber = InputView.inputTableNumber(tables);

    }

}
