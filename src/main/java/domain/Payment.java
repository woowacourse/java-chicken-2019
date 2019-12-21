package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Payment {
    public Payment() {
        pay();
    }

    public void pay() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        orderInformation(InputView.inputTableNumber());
    }

    public void orderInformation(int tableNumber) {
        System.out.println("##주문 내역");
        for (Order o : OrderList.search(tableNumber)) {
            System.out.println(o.getInformation());
        }
    }
}
