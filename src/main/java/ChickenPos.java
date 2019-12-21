import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.NoSuchElementException;

public class ChickenPos {
    private static final int MENU = 1;
    private static final int PAYMENT = 2;
    private static final int OFF = 3;

    private ChickenPos() {
    }

    public static ChickenPos init() {
        return new ChickenPos();
    }

    public void on() {
        int selectNumber = InputView.inputMainMenu();
        while (untilOff(selectNumber)) {
            doSelection(selectNumber);

            selectNumber = InputView.inputMainMenu();
        }
    }

    private boolean untilOff(int select) {
        return select != OFF;
    }

    private void doSelection(int select) {
        Table table = getTable();

        if (selectMenu(select)) {
            doOrder(table);
            return;
        }
        doPayment(table);
    }

    private void doOrder(Table table) {
        Order order = getOrder();
        table.addOrder(order);
    }

    private void doPayment(Table table) {
        if (table.hasNotOrders()) {
            OutputView.printNoOrders();
            doSelection(PAYMENT);
        }

        table.clear();
    }

    private Table getTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        try {
            return TableRepository.findById(tableNumber);
        } catch (NoSuchElementException e) {
            return getTable();
        }
    }

    private Order getOrder() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = InputView.inputMenuNumber();
        try {
            Menu menu = MenuRepository.findById(menuNumber);
            int menuSize = InputView.inputMenuAmount();

            return menu.toOrder(menuSize);
        } catch (NoSuchElementException e) {
            return getOrder();
        }
    }

    private boolean selectMenu(int select) {
        return select == MENU;
    }

}
