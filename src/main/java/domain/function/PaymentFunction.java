/*
 * @(#)PaymentFunction.java     0.2 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.function;

import domain.Payment.PaymentMethod;
import domain.menu.Menu;
import domain.menu.MenuQuantity;
import domain.table.Table;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class PaymentFunction extends Function {

    private static final int ZERO_CHICKEN_AMOUNT = 0;

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

        final PaymentMethod paymentMethod = getInputPaymentMethod();
        final int chickenAmount = getChickenDiscountNumber(orderedMenuStatus);

        final double finalOrderAmount = selectedTable.getOrderAmount(chickenAmount, paymentMethod);
        OutputView.printFinalOrderAmount(finalOrderAmount);
        selectedTable.resetTable();
    }

    private PaymentMethod getInputPaymentMethod() {
        try {
            int paymentMethod = InputView.inputPaymentMethod();
            return new PaymentMethod(paymentMethod);
        } catch (InputMismatchException e) {
            System.out.println("결재 수단은 신용카드 1번, 현금 2번, 두가지만 가능합니다.");
            return getInputPaymentMethod();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPaymentMethod();
        }
    }

    private int getChickenDiscountNumber(HashMap<Menu, MenuQuantity> orderedMenuStatus) {
        int chickenAmount = ZERO_CHICKEN_AMOUNT;
        for (Map.Entry<Menu, MenuQuantity> entry : orderedMenuStatus.entrySet()) {
            Menu menu = entry.getKey();
            MenuQuantity menuQuantity = entry.getValue();
            if (menu.isChicken()) {
                chickenAmount += menuQuantity.getMenuQuantity();
            }
        }
        return chickenAmount;
    }

}
