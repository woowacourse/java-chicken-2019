/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Application.java
 * 포스기를 실행시키는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

import java.util.List;

import domain.*;
import util.PosRule;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        int actionNumber;

        do {
            OutputView.printActionList();
            actionNumber = InputView.inputActionNumber();
            if (actionNumber != PosRule.TERMINATION) {
                action(actionNumber);
            }
        } while (actionNumber != PosRule.TERMINATION);

        System.exit(1);
    }

    private static void action(int actionNumber) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.getTableByNumber(tableNumber);

        if (actionNumber == PosRule.ORDER) {
            order(table);
        }
        if (actionNumber == PosRule.PAY) {
            if (table.hasOrder()) {
                pay(table);
                return;
            }
            OutputView.printCantPay();
        }
    }

    private static void order(Table table) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuNumber();
        final int menuCount = InputView.inputMenuCount();
        Menu menu = MenuRepository.getMenuByNumber(menuNumber);

        Order order = new Order(menu, menuCount);
        table.order(order);
        OutputView.printTables(TableRepository.tables());
    }

    private static void pay(Table table) {
        OutputView.printOrders(table.getOrders());
        OutputView.printPayMethod(table);
        final int payMethod = InputView.inputPayMethod();

        Payment payMent = new Payment(table, payMethod);
        payMent.pay();
        OutputView.printPayment(payMent.toString());
        table.completePayment();
    }
}
