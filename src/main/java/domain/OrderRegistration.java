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

        final int menuNumber = InputView.inputMenuChoice();
        final int menuCount = InputView.inputNumberOfMenu();        /* 해당 메뉴 주문 수량 */

        Menu menu = MenuRepository.menu(menuNumber);
        registerMenu(tableNumber, menu, menuCount);
    }

    private void registerMenu(final int tableNumber, final Menu menu, final int numberOfMenu) {
        Order order = new Order(numberOfMenu, menu);
        TableRepository.takeOrder(tableNumber, order);
    }
}
