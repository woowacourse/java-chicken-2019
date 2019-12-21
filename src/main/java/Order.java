import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Order {
    final static int MATCH_INDEX_WITH_INPUT = 1;

    public static void order(List<Table> tables, List<Menu> menus) {

        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);

        int menuNumber = InputView.inputMenuNumber();
        int menuHowMany = InputView.inputHowManyMenu();
        tables.get(tableNumber - MATCH_INDEX_WITH_INPUT)
                .getOrder(menus.get(menuNumber - MATCH_INDEX_WITH_INPUT), menuHowMany);
    }
}
