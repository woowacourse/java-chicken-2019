package domain.runner;

import domain.PayMethod;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PayRunner extends Runner {

    public static final int SELECT_NUMBER = 2;

    public static List<Table> tables = TableRepository.tables();

    public static void runPay() {
        OutputView.printTables(tables);
        Table table = inputTableInfo();
        OutputView.printOrderStatus(table);
        payProcessing(table);
    }

    private static void payProcessing(Table table) {
        OutputView.printTablePayProcessing(table);
        int paymentMethodNumber = InputView.inputPaymentMethodNumber();
        PayMethod payMethod = PayMethod.findPayMethod(paymentMethodNumber);
        int paymentResult = payMethod.getResultPayAccount(table);
        OutputView.printResultPayAccount(paymentResult);
        table.successPayProcessing();
    }

}
