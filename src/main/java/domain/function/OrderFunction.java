/*
 * @(#)OrderFunction.java       0.5 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.function;

import domain.table.Table;
import domain.menu.Menu;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderFunction extends Function {
    private final List<Menu> menus;
    public OrderFunction(List<Table> tables, List<Menu> menus) {
        super(tables);
        this.menus = menus;
    }

    @Override
    public void operateFunction() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        final Table selectedTable = tables.stream()
                .filter(table -> table.isSelectedTable(tableNumber))
                .findFirst()
                .get();

        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuNumber();
        final Menu selectedMenu = menus.stream()
                .filter(menu -> menu.isSelectedMenu(menuNumber))
                .findFirst()
                .get();
        addSelectedOrderMenu(selectedTable, selectedMenu);
    }

    private void addSelectedOrderMenu(Table selectedTable, Menu selectedMenu) {
        try {
            final int menuQuantity = InputView.inputMenuQuantity();
            selectedTable.addOrderMenu(selectedMenu, menuQuantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addSelectedOrderMenu(selectedTable, selectedMenu);
        }
    }
}
