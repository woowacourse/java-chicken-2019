package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Pos {
    public void pos() {
        OutputView.printMenu();
        final int inputMenu = InputView.inputMenu();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables, TableRepository.getOrderCheck());

        final int tableNumber = InputView.inputTableNumber();
        TableRepository.setOrderCheck(tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int inputOrder = InputView.inputOrder();
        final int inputCount = InputView.inputCount();
    }
}
