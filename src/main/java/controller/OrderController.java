package controller;

import domain.*;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static validation.InputValidator.inputTableNumberValidator;
import static view.InputView.*;

public class OrderController {
    public List<OrderedTable> orderedTables = new ArrayList<>();

    public List<OrderedTable> orderController(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        int tableNumber = controlTableChoose();
        OutputView.printMenus(menus);
        int menuNumber = controlMenuChoose();
        int orderQuantity = controlQuantityChoose();
        Order order = makeOrder(menuNumber, orderQuantity);
        orderedTables.add(makeOrderedTable(tableNumber, order));
        return orderedTables;
    }

    public int controlTableChoose() {
        OutputView.askToChooseTableNumber();
        return getTableNumber();
    }

    public int controlMenuChoose() {
        OutputView.askToChooseMenuNumber();
        return getMenuNumber();
    }

    public int controlQuantityChoose() {
        OutputView.askToChooseQuantity();
        return getOrderQuantity();
    }

    public Order makeOrder(int menuNumber, int orderQuantity) {
        Order order = new Order(menuNumber, orderQuantity);
        return order;
    }

    public OrderedTable makeOrderedTable(int tableNumber, Order order) {
        OrderedTable orderedTable = new OrderedTable(tableNumber, order);
        return orderedTable;
    }

}
