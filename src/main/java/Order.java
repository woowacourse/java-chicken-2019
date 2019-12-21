import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Order {

    public static void order(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);

        int menuNumber = InputView.inputMenuNumber();
        int menuHowMany = InputView.inputHowManyMenu();
        tables.get(tableNumber)
                .registerOrder(menus.get(menuNumber), menuHowMany);
    }
}
