/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.*;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static view.InputView.getMainFunctionNumber;

public class PosController {
    private static final int ONE = 1;
    private static final int THREE = 3;
    List<Table> tables = TableRepository.tables();
    List<Menu> menus = MenuRepository.menus();
    private List<OrderedTable> orderedTables = new ArrayList<>();

    public void posController() {
        OutputView.printMainPage();
        int funcDecideNumber;
        do {
            funcDecideNumber = setFunction();
            chooseOrderOrPay(funcDecideNumber);
        } while (funcDecideNumber != THREE);
        return;
    }

    public int setFunction() {
        return getMainFunctionNumber();
    }

    public void chooseOrderOrPay(int inputNumber) {
        if (inputNumber == THREE) {
            return;
        }

        if (inputNumber == ONE) {
            OrderController orderController = new OrderController();
            orderedTables = orderController.orderController(tables, menus);

            return;
        }

        PaymentController paymentController = new PaymentController();
        paymentController.paymentController(orderedTables);


    }
}
