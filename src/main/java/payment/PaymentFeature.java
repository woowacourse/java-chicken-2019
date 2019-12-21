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
        inputPaymentType(table);
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

    private int inputPaymentType(Table table) {
        PaymentType paymentType = InputView.inputPaymentType();
        int noneDiscountTotalPrice = getNoneDiscountTotalPrice(table);
        int chickenDiscountTotalPrice = discountChickenNumber(table, noneDiscountTotalPrice);
        if (paymentType.isTypeMoney()) {
            // 현금 금액 생성
            return (int) discountMoney(chickenDiscountTotalPrice);
        }
        return chickenDiscountTotalPrice;
    }

    private int getNoneDiscountTotalPrice(Table table) {
        return table
                .getOrderedMenus()
                .calcurateTotalPrice();
    }

    private int discountChickenNumber(Table table, int noneDiscountTotalPrice) {
        int chickenCount = table.getOrderedMenus().calcurateChickenCount();
        while (chickenCount > 0) {
            if (chickenCount >= 10) {
                noneDiscountTotalPrice -= 10000;
            }
            chickenCount -= 10;
        }
        return noneDiscountTotalPrice;
    }

    private double discountMoney(int noneDiscountMoneyPrice) {
        return noneDiscountMoneyPrice - (noneDiscountMoneyPrice * 0.05);
    }
}
