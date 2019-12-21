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
    }

    private void pay(int tableNum, int paymentMethod) {

    }
}
