import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Payment {

    public static void payment(List<Table> tables) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();

        HashMap<Menu, Integer> order = tables.get(tableNumber).getOrder();

        OutputView.printBill(order);
        final int methodNumber = InputView.inputPayMethod(tableNumber);
        final int payment = getPayment(order);
        OutputView.printAmountOfPayment(calculateDiscount(order, methodNumber));
    }

    private static int calculateDiscount(HashMap<Menu,Integer> order , int method) {
        int payment = getPayment(order);
        payment = Discount.calculateDiscountByNumberOfMenu(order, payment);
        payment = Discount.calculateDiscountByMethod(method, payment);
        return payment;
    }

    private static int getPayment(HashMap<Menu,Integer> order) {
        // TODO
        return 0;
    }
}
