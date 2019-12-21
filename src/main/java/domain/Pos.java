package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Pos {
    private static final int LOOP_CODE = 0;
    private static final int ORDER_CODE = 1;
    private static final int PAY_CODE = 2;
    private static final int EXIT_CODE = 3;

    public int pos() {
        OutputView.printMenu();
        final int inputMenu = InputView.inputMenu();
        if (inputMenu == EXIT_CODE) {
            return EXIT_CODE;
        }

        manager(inputMenu);

        return LOOP_CODE;
    }

    private void manager(int inputMenu) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables, TableRepository.getOrderCheck());

        final int tableNumber = InputView.inputTableNumber();
        TableRepository.setOrderCheck(tableNumber);

        if (inputMenu == ORDER_CODE) {
            registerOrder(tableNumber);
        }
        if (inputMenu == PAY_CODE) {
            pay(tableNumber);
        }
    }

    public void registerOrder(int tableNumber) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int inputOrder = InputView.inputOrder();
        final int inputCount = InputView.inputCount();
        orderManagement(tableNumber, inputOrder, inputCount);
    }

    public void pay(int tableNumber) {
        OutputView.printReceipt(tableNumber);
        InputView.printPay(tableNumber);
        OutputView.printTotalPayment(tableNumber);
    }

    public static void orderManagement(int tableNumber, int inputOrder, int inputCount) {
        TableRepository.addNewOrder(TableRepository.getTableMenu()
                .stream()
                .filter(x -> x.getNumber() == tableNumber)
                .findFirst().get(), inputOrder, inputCount);
    }
}
