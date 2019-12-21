package order;

import domain.Menu;
import domain.MenuRepository;
import domain.reserved.OrderStatement;
import domain.reserved.OrderedMenu;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Order {
    public static void startOrder(OrderStatement orderStatement) {
        inputOrder(orderStatement);
    }

    private static void inputOrder(OrderStatement orderStatement) {
        final List<Menu> menus = MenuRepository.menus();
        int tableNumber = inputTableNumber(orderStatement);
        int menuId = inputMenuId(menus);
        int capacitiy = inputCapacity(orderStatement, tableNumber, menuId);
        orderStatement.addTableOrderStatement(tableNumber, careateOrderedMenu(menuId, capacitiy));
    }

    private static OrderedMenu careateOrderedMenu(int menuId, int capacity) {
        Menu menu = MenuRepository.getMenuBy(menuId);
        return OrderedMenu.createMenu(menu, capacity);
    }

    private static int inputTableNumber(OrderStatement orderStatement) {
        OutputView.printTables(orderStatement.getTables());
        return InputView.inputTableNumber(orderStatement);
    }

    private static int inputMenuId(List<Menu> menus) {
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber();
    }

    private static int inputCapacity(OrderStatement orderStatement, int tableNumber, int menuId) {
        if (orderStatement.isExist(tableNumber, menuId)) {
            OrderedMenu orderedMenu = orderStatement
                    .getTableOrderStatementBy(tableNumber)
                    .getOrderedMenus()
                    .getMenuBy(menuId);
            return InputView.inputCapacity(orderedMenu);
        }
        return InputView.inputCapacity(null);
    }

}
