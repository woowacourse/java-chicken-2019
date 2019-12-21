package Service;

import domain.NextStep;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

import static domain.TableRepository.isExistTable;

public class PosService {
    public void run() {
        NextStep nextStep;
        final List<Table> tables = TableRepository.tables();

        do {
            OutputView.printMain();
            nextStep = choiceNextStep();
            if (nextStep.isExit()) return;
            // 주문을 등록하지 않고 결제하는 경우 예외

            OutputView.printTables(tables);
            final int tableNumber = checkExistTable(InputView.inputTableNumber());
            Table selectedTable = selectTable(tables, tableNumber);
            doNextStep(nextStep, selectedTable);
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

    private int checkExistTable(int number) {
        try {
            if (!isExistTable(number)) {
                throw new IllegalStateException("없는 테이블 번호입니다.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            number = checkExistTable(InputView.inputTableNumber());
        }
        return number;
    }

    private void doNextStep(NextStep nextStep, Table table) {
        OrderService orderService = new OrderService();
        PayService payService = new PayService();

        if (nextStep.isOrder()) {
            orderService.order(table);
        }
        if (nextStep.isPay()) {
            payService.pay(table);
        }
    }
}
