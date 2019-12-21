package payment;

import domain.reserved.OrderStatement;
import view.InputView;
import view.OutputView;

public class PaymentFeature {
    public void startPayment(OrderStatement orderStatement) {
        int tableNumber = inputTableNumber(orderStatement);
        
        tableNumber = checkNoneOrderedMenu(orderStatement, tableNumber);
    }

    private int inputTableNumber(OrderStatement orderStatement) {
        int tableNumber = InputView.inputTableNumber(orderStatement);
        boolean isExistMenu = orderStatement
                .getTableOrderStatementBy(tableNumber)
                .isExistMenu();
        if (isExistMenu == false) {
            OutputView.printNoExistTablePayment();
            tableNumber = InputView.inputTableNumber(orderStatement);
        }
        return tableNumber;
    }
}
