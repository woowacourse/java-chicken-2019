package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Pos {
    private static final int EXIT_CODE = 3;

    public int pos() {
        OutputView.printMenu();
        final int inputMenu = InputView.inputMenu();

        if (inputMenu == EXIT_CODE) {
            return EXIT_CODE;
        }
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables, TableRepository.getOrderCheck());

        final int tableNumber = InputView.inputTableNumber();
        TableRepository.setOrderCheck(tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int inputOrder = InputView.inputOrder();
        final int inputCount = InputView.inputCount();
        orderManagement(tableNumber, inputOrder, inputCount);

        return inputMenu;
    }

    public static void orderManagement(int tableNumber, int inputOrder, int inputCount) {
        TableRepository.addNewOrder(TableRepository.getTableMenu()
                .stream()
                .filter(x -> x.getNumber() == tableNumber)
                .findFirst().get(), inputOrder, inputCount);
    }
}
