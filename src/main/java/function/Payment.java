package function;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Payment {
    static final List<Table> TABLES = TableRepository.tables();
    private int tableNumber;

    public void payment(){
        OutputView.printTablesPayment(TABLES,Order.tableMoney);
        tableNumber = InputView.inputPaymentTable();
        tableNumber = tableNumber -1;

        System.out.println("#최종 결제할 금액#");
        System.out.println(Order.tableMoney.get(TABLES.get(tableNumber)));

        Order.tableMoney.put(TABLES.get(tableNumber),0);
    }
}
