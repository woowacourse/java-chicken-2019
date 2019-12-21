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
    }
}
