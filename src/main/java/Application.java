import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static final Tables tables = new Tables(TableRepository.tables());
    public static final List<Menu> menus = MenuRepository.menus();

    private static final int ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int CASH = 2;
    private static final int MANY_ORDER_BOUNDARY = 10;
    private static final int HAS_MANY_ORDER_DISCOUNT = 100000;
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
        tables.addOrder(tableNumber, order);
    }

    private static void runPayment() {
        if(tables.hallIsEmpty()) {
            System.out.println("================");
            System.out.println("주문이 없습니다");
            System.out.println("================");
            return ;
        }
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputPaymentTableNumber();
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

}
