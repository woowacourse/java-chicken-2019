/*
 * @(#)PaymentFunction.java     0.2 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.function;

import domain.Table;
import domain.menu.Menu;
import domain.menu.MenuQuantity;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class PaymentFunction extends Function {
    public PaymentFunction(List<Table> tables) {
        super(tables);
    }

    @Override
    public void operateFunction() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        final Table selectedTable = tables.stream()
                .filter(table -> table.isSelectedTable(tableNumber))
                .findFirst()
                .get();

        final HashMap<Menu, MenuQuantity> orderedMenuStatus = selectedTable.getMenuStatus();
        OutputView.printOrderedMenuStatus(orderedMenuStatus);
    }
}
