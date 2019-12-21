package Service;

import domain.NextStep;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosService {
    public void run() {
        OrderService orderService = new OrderService();
        PayService payService = new PayService();
        NextStep nextStep;
        final List<Table> tables = TableRepository.tables();

        do {
            OutputView.printMain();
            nextStep = choiceNextStep();
            if (nextStep.isExit()) return;
            // 주문을 등록하지 않고 결제하는 경우 예외

            OutputView.printTables(tables);
            final int tableNumber = InputView.inputTableNumber();
            Table selectedTable = selectTable(tables, tableNumber);

            if (nextStep.isOrder()) {
                orderService.order(selectedTable);
            }
            if (nextStep.isPay()) {
                payService.pay(selectedTable);
            }
        }
        while (!nextStep.isExit());
    }

    private NextStep choiceNextStep() {
        NextStep nextStep;

        try {
            nextStep = new NextStep(InputView.inputNextStep());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            nextStep = new NextStep(InputView.inputNextStep());
        }
        return nextStep;
    }

    private Table selectTable(List<Table> tables, int number) {
        return tables.stream()
                .filter(table -> table.isSameTableNumber(number))
                .findFirst()
                .get();
    }
}
