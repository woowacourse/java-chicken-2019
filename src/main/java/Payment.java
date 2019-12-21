import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Payment {

    public static void payment(List<Table> tables) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printBill(tables.get(tableNumber).getOrder());
    }
}
