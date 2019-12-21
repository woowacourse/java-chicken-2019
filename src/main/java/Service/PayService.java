package Service;

import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.HashMap;

public class PayService {
    private static final int CASH = 2;
    private static final double DEFAULT_RATE = 1.0;
    private static final double CASH_SALE_RATE = 0.05;
    private static final int AMOUNT_SALE_CONDITION = 10;
    private static final int AMOUNT_SALE_PRICE = 10000;

    public void pay(Table table) {
        HashMap<Menu, Integer> bill = table.getBill();
        OutputView.printOrderHistory(bill);

        int paymentMethod = InputView.inputPaymentMethod(table.getNumber());
        int price = calculatePrice(table, paymentMethod);

        OutputView.printTotalPrice(price);
    }

    private int calculatePrice(Table table, int paymentMethod) {
        int price = table.getTotalPrice();
        int amount = table.getTotalAmount();

        if (amount >= AMOUNT_SALE_CONDITION) {
            price -= AMOUNT_SALE_PRICE * amount / 10;
        }

        if (paymentMethod == CASH) {
            price *= (DEFAULT_RATE - CASH_SALE_RATE);
        }
        return price;
    }
}
