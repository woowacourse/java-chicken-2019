import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    
    public static final Tables tables = new Tables(TableRepository.tables());
    public static final List<Menu> menus = MenuRepository.menus();

    private static final int ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int CASH = 2;
    private static final int MANY_ORDER_BOUNDARY = 10;
    private static final int HAS_MANY_ORDER_DISCOUNT = 10000;
    private static final int MAXIMUM_QUANTITY = 99;
    private static final double CASH_DISCOUNT_RATES = 0.95;

    private static int mainMenuNumber = 1;

    public static void main( String[] args ) {
        while (isRunnable()) {
            OutputView.printMainMenus();
            mainMenuNumber = InputView.inputMainNumber();
            runProcess(mainMenuNumber);
        }
        OutputView.printEndProgram();
    }

    private static boolean isRunnable() {
        return (mainMenuNumber == ORDER) || (mainMenuNumber == PAYMENT);
    }

    private static void runProcess( int mainMenu ) {
        if (mainMenu == ORDER) {
            runOrder();
            return;
        }
        if (mainMenu == PAYMENT) {
            runPayment();
            return;
        }
    }

    private static void runOrder() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final int menuQuantity = InputView.inputMenuQuantity();
        Order order = new Order(menuNumber, menuQuantity);
        if (checkOrder(tableNumber, menuNumber, menuQuantity)) {
            OutputView.printNotAbleOrder();
            return;
        }
        tables.addOrder(tableNumber, order);
        for( Table table: tables.tables() ) {
            System.out.println(table.orderToString());
        }
    }

    private static boolean checkOrder( int tableNumber, int menuNumber, int menuQuantity ) {
        boolean isAble = false;
        Table current = tables.getTable(tableNumber);
        int menuAmount = current.targetOrderSize(menuNumber);
        return menuAmount + menuQuantity > MAXIMUM_QUANTITY;
    }

    private static void runPayment() {
        if (tables.hallIsEmpty()) {
            OutputView.printNoOrder();
            return;
        }
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputPaymentTableNumber();
        if (hasNoOrder(tableNumber)) {
            OutputView.printNoOrder();
            return;
        }
        final int paymentMethod = InputView.inputPaymentMethod(tableNumber);
        double amount = calculateFinalPayment(tableNumber, paymentMethod);
        OutputView.printOrderAmount(amount);
        tables.payment(tableNumber);
    }

    private static double calculateFinalPayment( int tableNumber, int paymentMethod ) {
        Table current = tables.getTable(tableNumber);
        double amount = current.getAmount();
        if (paymentMethod == CASH) {
            amount = amount * CASH_DISCOUNT_RATES;
        }
        if (hasManyOrder(current)) {
            int orderAmount = current.getOrderSize();
            amount = amount - (orderAmount / MANY_ORDER_BOUNDARY) * HAS_MANY_ORDER_DISCOUNT;
        }
        return amount;
    }

    private static boolean hasManyOrder( Table table ) {
        return table.getOrderSize() >= MANY_ORDER_BOUNDARY;
    }

    private static boolean hasNoOrder( int tableNumber ) {
        Table current = tables.getTable(tableNumber);
        return !current.hasOrder();
    }
}
