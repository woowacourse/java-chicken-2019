package payment;

import domain.Table;
import domain.reserved.OrderStatement;
import view.InputView;
import view.OutputView;
import view.dto.PaymentType;

public class PaymentFeature {
    public void startPayment(OrderStatement orderStatement) {
        int tableNumber = inputTableNumber(orderStatement);
        Table table = orderStatement.getTableOrderStatementBy(tableNumber);
        table.getOrderedMenus().printOrderedMenu();
    }

    private int inputTableNumber(OrderStatement orderStatement) {
        OutputView.printTables(orderStatement.getTables());
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

    private void inputPaymentType() {
        PaymentType paymentType = InputView.inputPaymentType();
        if (paymentType.isTypeCard()) {
            // 카드 금액 생성
        }
        if (paymentType.isTypeMoney()) {
            // 현금 금액 생
        }
    }

    private void discountChickenNumber() {

    }
}
