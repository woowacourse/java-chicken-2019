package domain.runner;

import domain.PayMethod;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PayRunner extends Runner {

    public static List<Table> tables = TableRepository.tables();

    public static void runPay() {
        OutputView.printTables(tables);
        Table table = inputTableInfo();
        OutputView.printOrderStatus(table);
        payProcessing(table);
    }

    private static void payProcessing(Table table) {
        OutputView.printTablePayProcessing(table);
        PayMethod payMethod = PayMethod.findPayMethod(InputView.inputPaymentMethodNumber());
        OutputView.printResultPayAccount(payMethod.getResultPayAccount(table));
        table.successPayProcessing();
    }

}
