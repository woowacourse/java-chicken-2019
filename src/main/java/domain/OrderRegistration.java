package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderRegistration {
    public void controlOrderRegistration() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menu = InputView.inputMenuChoice();
        final int numberOfMenu = InputView.inputNumberOfMenu();

        registerMenu(tableNumber, menu, numberOfMenu);
    }

    private void registerMenu(final int tableNumber, final int menu, final int numberOfMenu) {
        Order order = new Order(numberOfMenu, menu);
        TableRepository.takeOrder(tableNumber, order);
    }
}
