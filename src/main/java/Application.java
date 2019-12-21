import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    // TODO 구현 진행

    public static void main(String[] args) {
        boolean isProgress = true;
        final List<Table> tables = TableRepository.tables();
        final List<Order> orders = new ArrayList<>();
        do {
            int mainNumber = InputView.inputMainNumber();
            if (mainNumber == 1) {
                orders.add(orderSelect(tables));
            }
            if (mainNumber == 2) {
                paymentSelect(tables, orders);
            }
            if (mainNumber == 3) {
                OutputView.printProgramExit();
                isProgress = false;
            }
        } while (isProgress);
    }

    public static Order orderSelect(List<Table> tables) {
        final List<Menu> menus = MenuRepository.menus();

        final int tableNumber = InputView.inputTableNumber(tables);
        final int menuNumber = InputView.inputMenuNumber(menus);
        final int quantityNumber = InputView.inputMenuQuantity();

        Table table = new Table(tableNumber);
        Menu menu = MenuRepository.getmenu(menuNumber);

        return new Order(table, menu, quantityNumber);
    }

    public static void paymentSelect(List<Table> tables, List<Order> orders) {
        final int tableNumber = InputView.inputTableNumber(tables);
        List<Order> tableOrders = orders.stream().filter(order -> order.orderCheck(tableNumber)).collect(Collectors.toList());

        OutputView.printOrderList(tableOrders, tableNumber);

        final int paymentSelect = InputView.inputPayment();

        Calculator calculator = new Calculator(paymentSelect, tableOrders);
        int paymentPrice = calculator.getTotalPrice();

        OutputView.printFinalPayment(paymentPrice);
    }
}
