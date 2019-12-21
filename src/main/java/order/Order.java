package order;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.reserved.OrderStatement;
import domain.reserved.OrderedMenu;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Order {

    public void startOrder(OrderStatement orderStatement) {
        inputOrder(orderStatement);
    }

    public void inputOrder(OrderStatement orderStatement) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        int tableNumber = inputTableNumber(tables);
        int menuId = inputMenuId(menus);
        int capacitiy = inputCapacity(orderStatement, tableNumber, menuId);
        orderStatement.addTableOrderStatement(tableNumber, careateOrderedMenu(menuId, capacitiy));
    }

    public OrderedMenu careateOrderedMenu(int menuId, int capacity) {
        Menu menu = MenuRepository.getMenuBy(menuId);
        return OrderedMenu.createMenu(menu, capacity);
    }

    public int inputTableNumber(List<Table> tables) {
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    public int inputMenuId(List<Menu> menus) {
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber();
    }

    public int inputCapacity(OrderStatement orderStatement, int tableNumber, int menuId) {
        if (orderStatement.isExist(tableNumber, menuId)) {
            OrderedMenu orderedMenu = orderStatement
                    .getTableOrderStatementBy(tableNumber)
                    .getOrderedMenus()
                    .getMenuBy(menuId);
            return InputView.inputCapacity(orderedMenu);
        }
        return InputView.inputCapacity(null);
    }

    public void addMenuInOrderStatement(OrderStatement orderStatement) {

    }

}
