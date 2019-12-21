package payment;

import domain.Table;
import domain.reserved.OrderStatement;
import view.InputView;
import view.OutputView;
import view.dto.PaymentType;

public class PaymentFeature {

    public static void startPayment(OrderStatement orderStatement) {
        int tableNumber = inputTableNumber(orderStatement);
        Table table = orderStatement.getTableOrderStatementBy(tableNumber);
        table.getOrderedMenus().printOrderedMenu();
        int price = inputPaymentType(table);
        OutputView.printPrice(price);
    }

    private static int inputTableNumber(OrderStatement orderStatement) {
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

    private static int inputPaymentType(Table table) {
        PaymentType paymentType = InputView.inputPaymentType();
        int noneDiscountTotalPrice = getNoneDiscountTotalPrice(table);
        int chickenDiscountTotalPrice =
                DiscountCalcurater.discountChickenNumber(table, noneDiscountTotalPrice);
        if (paymentType.isTypeMoney()) {
            return (int) DiscountCalcurater.discountMoney(chickenDiscountTotalPrice);
        }
        return chickenDiscountTotalPrice;
    }

    private static int getNoneDiscountTotalPrice(Table table) {
        return table
                .getOrderedMenus()
                .calcurateTotalPrice();
    }
}
