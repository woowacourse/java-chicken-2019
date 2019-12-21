package payment;

import domain.Table;
import domain.reserved.OrderStatement;
import view.InputView;
import view.OutputView;
import view.dto.PaymentType;

public class PaymentFeature {
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final double MONEY_DISCOUTN_RATE = 0.05;
    private static final int MILLION = 10000;

    public void startPayment(OrderStatement orderStatement) {
        int tableNumber = inputTableNumber(orderStatement);
        Table table = orderStatement.getTableOrderStatementBy(tableNumber);
        table.getOrderedMenus().printOrderedMenu();
        int price = inputPaymentType(table);
        OutputView.printPrice(price);
    }

    private int inputTableNumber(OrderStatement orderStatement) {
        OutputView.printTables(orderStatement.getTables());
        int tableNumber = InputView.inputTableNumber(orderStatement);
        boolean isExistMenu = orderStatement
                .getTableOrderStatementBy(tableNumber)
                .isExistMenu();
        if (!isExistMenu) {
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
        while (chickenCount > ZERO) {
            if (chickenCount >= TEN) {
                noneDiscountTotalPrice -= MILLION;
            }
            chickenCount -= TEN;
        }
        return noneDiscountTotalPrice;
    }

    private double discountMoney(int noneDiscountMoneyPrice) {
        return noneDiscountMoneyPrice - (noneDiscountMoneyPrice * MONEY_DISCOUTN_RATE);
    }
}
