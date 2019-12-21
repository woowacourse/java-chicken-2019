import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Payment {

    public static void payment(List<Table> tables) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();

        HashMap<Menu, Integer> order = tables.get(tableNumber).getOrder();

        OutputView.printBill(order);
        final int methodNumber = InputView.inputPayMethod(tableNumber);
        OutputView.printAmountOfPayment(calculateDiscount(order, methodNumber));
    }

    private static int calculateDiscount(HashMap<Menu,Integer> order , int method) {
        int payment = getPayment(order);
        payment = Discount.calculateDiscountByNumberOfMenu(order, payment);
        payment = Discount.calculateDiscountByMethod(method, payment);
        return payment;
    }

    private static int getPayment(HashMap<Menu,Integer> order) {
        List<Integer> priceOfMenu;
        List<Integer> numberOfMenu;

        priceOfMenu = getPriceList(order);
        numberOfMenu = getNumberList(order);

        return sumPayment(priceOfMenu, numberOfMenu);
    }

    private static int sumPayment(List<Integer> priceList, List<Integer> numberList) {
        int payment = 0;
        for (int i = 0; i < priceList.size(); i++) {
            payment += priceList.get(i) * numberList.get(i);
        }
        return payment;
    }

    private static List<Integer> getPriceList(HashMap<Menu,Integer> order) {
        List<Integer> priceOfMenu = new ArrayList<>(order.size());
        for (Menu menu : order.keySet()) {
            priceOfMenu.add(menu.getPrice());
        }

        return priceOfMenu;
    }

    private static List<Integer> getNumberList(HashMap<Menu,Integer> order) {
        List<Integer> numberOfMenu = new ArrayList<>(order.size());
        for (int value : order.values()) {
            numberOfMenu.add(value);
        }

        return numberOfMenu;
    }


}
