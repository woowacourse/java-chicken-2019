/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.*;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static domain.MenuRepository.getMenu;
import static view.InputView.*;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 주문을 컨트롤하는 클래스입니다. (1번 기능)
 * @since : 2019.12.23 월요일
 */
public class OrderController {

    public static List<Table> orderedTables = new ArrayList<>();

    public List<Table> orderController(List<Table> tables, List<Menu> menus) {
        int tableNumber = controlTableChoose(tables, orderedTables);
        int menuNumber = controlMenuChoose(menus);
        Menu newMenu = getMenu(menuNumber);

        Quantity orderQuantity = controlQuantityChoose();
        Order newOrder = makeOrder(newMenu, orderQuantity);
        Table orderedTable = makeOrReuseTable(tableNumber);
        orderedTable.setOrder(newOrder);
        return orderedTables;
    }

    public Table makeOrReuseTable(int tableNumber) {
        for (Table orderedTable : orderedTables) {
            if (orderedTable.isSameTable(tableNumber)) {
                return orderedTable;
            }
        }
        Table orderedTable = new Table(tableNumber);
        orderedTables.add(orderedTable);
        return orderedTable;
    }

    public int controlTableChoose(List<Table> tables, List<Table> orderedTables) {
        OutputView.printTables(tables, orderedTables);
        OutputView.askToChooseTableNumber();
        return getTableNumber();
    }

    public int controlMenuChoose(List<Menu> menus) {
        OutputView.printMenus(menus);
        OutputView.askToChooseMenuNumber();
        return getMenuNumber();
    }

    public Quantity controlQuantityChoose() {
        OutputView.askToChooseQuantity();
        Quantity quantity = new Quantity();
        quantity.putQuantity(getOrderQuantity());
        return quantity;
    }

    public Order makeOrder(Menu newMenu, Quantity orderQuantity) {
        Order order = new Order(newMenu, orderQuantity);
        return order;
    }


}
