package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderRegistration {
    public void registerOrder() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
