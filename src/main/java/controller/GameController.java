package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import order.OrderList;
import utils.Calculate;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameController {

    private static final int ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int EXIT = 3;

    private final List<Table> tables;
    private final List<Menu> menus;
    private final HashMap<Table, OrderList> orderList;

    public GameController() {
        tables = TableRepository.tables();
        menus = MenuRepository.menus();
        orderList = new HashMap();
        for (Table table : tables) {
            orderList.put(table, new OrderList());
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
        OutputView.printTables(tables, orderList);
        final Table table = getTable(InputView.inputTableNumber());
                OutputView.printMenus(menus);
        final Menu menu = foreignKeyGetMenu(InputView.inputMenuNumber());
        final int quantityNumber = InputView.inputMenuQuantityNumber();
        orderList.get(table).addMenu(menu, quantityNumber);
    }

    private Table getTable(int tableNumber) {
        for (Table table : tables) {
            if(table.getNumber() == tableNumber)
                return table;
        }
        // 예외처리해줘야함
        return null;
    }

    private Menu foreignKeyGetMenu(int number) {
        for (Menu menu : menus) {
            if (menu.isForeignKey(number))
                return menu;
        }
        return null;
    }

    private void tablePayment() {
        OutputView.printTables(tables, orderList);
        final Table table = getTable(InputView.inputTableNumber());
        OutputView.printOrderHistory(orderList.get(table).orderListToStringArray());
        final int paymentType = InputView.inputCardOrCash(table.getNumber());
        final int resultPrice = Calculate.amountCalculation(orderList.get(table).getTotalPrice()
                , orderList.get(table).getChickenCount()
                , paymentType);
        OutputView.printFinalPaymontAmount(resultPrice);
        orderList.get(table).vacateOrder();
    }
}
