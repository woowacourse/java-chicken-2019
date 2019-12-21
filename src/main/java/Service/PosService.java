package Service;

import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosService {
    private static final int ORDER = 1;
    private static final int PAY = 2;

    public void run(int nextStep) {
        OrderService orderService = new OrderService();
        PayService payService = new PayService();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        Table selectedTable = selectTable(tables, tableNumber);

        if (nextStep == ORDER) {
            orderService.order(selectedTable);
        }
        if (nextStep == PAY) {
            payService.pay(selectedTable);
        }
    }

    private Table selectTable(List<Table> tables, int number) {
        return tables.stream()
                .filter(table -> table.isSameTableNumber(number))
                .findFirst()
                .get();
    }
}
