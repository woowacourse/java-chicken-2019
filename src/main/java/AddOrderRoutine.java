import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import javax.naming.SizeLimitExceededException;
import java.util.List;

public class AddOrderRoutine {
    public static void addOrderRoutine(List<Table> tables, List<Menu> menus) throws SizeLimitExceededException {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenu();
        Menu menu = matchMenuNumber(menus, menuNumber);

        int quantity = InputView.inputQuantity();
        while (quantity-- > 0) {
            tables.get(tableNumber).addOrder(menu);
        }
    }

    private static Menu matchMenuNumber(List<Menu> menus, int menuNumber) {
        Menu menu = null;
        for (Menu it : menus) {
            if (it.isMatchedMenu(menuNumber)) {
                menu = it;
                break;
            }
        }
        if (menu == null)
            throw new NullPointerException();
        return menu;
    }

}
