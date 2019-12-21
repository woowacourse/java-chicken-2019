package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import order.OrderList;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final int ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int EXIT = 3;

    private final List<Table> tables;
    private final List<Menu> menus;
    private final ArrayList<OrderList> orderList;

    public GameController() {
        tables = TableRepository.tables();
        menus = MenuRepository.menus();
        orderList = new ArrayList<>();
        for (int i = 0; i < tables.size() + 1; i++) {
            orderList.add(new OrderList());
        }
    }

    public void gameStart() {
        int answer = 0;
        while (answer != EXIT) {
            OutputView.printMainMenu();
            answer = InputView.inputMainFunction();
            if (answer == ORDER)
                tableOrder();
            if (answer == PAYMENT)
                tablePayment();
        }
    }

    private void tableOrder() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        final Menu menu = foreignKeyGetMenu(InputView.inputMenuNumber());
        final int quantityNumber = InputView.inputMenuQuantityNumber();
        orderList.get(tableNumber).addMenu(menu, quantityNumber);
    }

    private Menu foreignKeyGetMenu(int number) {
        for (Menu menu : menus) {
            if (menu.isForeignKey(number))
                return menu;
        }
        return null;
    }

    private void tablePayment() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printOrderHistory(orderList.get(tableNumber).orderListToStringArray());
        InputView.inputCardOrCash(tableNumber);
        OutputView.printFinalPaymontAmount();
    }

}
