/*
 * @(#)PaymentFunction.java     0.2 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.function;

import domain.table.Table;
import domain.menu.Menu;
import domain.menu.MenuQuantity;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.InputMismatchException;
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

        final int paymentMethod = getInputPaymentMethod();
    }

    private int getInputPaymentMethod() {
        try {
            return InputView.inputPaymentMethod();
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("결재 수단은 신용카드 1번, 현금 2번, 두가지만 가능합니다.");
            return getInputPaymentMethod();
        }
    }

}
