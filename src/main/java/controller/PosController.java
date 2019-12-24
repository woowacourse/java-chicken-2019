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

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 포스기를 컨트롤하는 클래스입니다.
 * @since : 2019.12.23 월요일
 */
public class PosController {
    private static final int ONE = 1;
    private static final int THREE = 3;
    List<Table> tables = TableRepository.tables();
    List<Menu> menus = MenuRepository.menus();
    private List<Table> orderedTables = new ArrayList<>();

    public void posController() {
        int funcDecideNumber;
        do {
            OutputView.printMainPage();
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
        orderedTables = paymentController.paymentController(tables, menus, orderedTables);

    }
}
