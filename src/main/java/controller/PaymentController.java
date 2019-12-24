/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.Menu;
import domain.Order;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static view.InputView.getPaymentMethod;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 결제를 컨트롤하는 클래스입니다. (2번 기능)
 * @since : 2019.12.23 월요일
 */
public class PaymentController {
    public List<Table> orderedTables = new ArrayList<>();

    public List<Table> paymentController(List<Table> tables, List<Menu> menus, List<Table> inputOrderedTables) {
        if (inputOrderedTables.isEmpty()) {
            OutputView.printNoOrderedTableGoBackToMain();
            return inputOrderedTables;
        }
        orderedTables = inputOrderedTables;
        int tableNumber = controlTableChooseForPayment(tables, orderedTables);
        OutputView.printOrderListTitle();
        printOrderList(getTable(tableNumber));
        int paymentMethod = controlPaymentMethod(tableNumber);
        MoneyCalculateController.calculateMoney(paymentMethod, getTable(tableNumber));
        orderedTables.remove(getTable(tableNumber));
        return orderedTables;
    }

    public int controlTableChooseForPayment(List<Table> tables, List<Table> orderedTables) {
        OutputView.printTables(tables, orderedTables);
        OutputView.askToChooseTableNumber();
        return InputView.getTableNumberForPayment(orderedTables);
    }

    public Table getTable(int tableNumber) {
        for (Table table : orderedTables) {
            if (table.isSameTable(tableNumber)) {
                return table;
            }
        }
        return null;
    }

    public void printOrderList(Table payingTable) {
        OutputView.printMenuQuantityPrice();
        for (Order order : payingTable.getOrders()) { //오더가 없을 경우 예외처리 해주기 # 지금 1ㅇ에 주문해두고 2에서 결제하는데 그거에서 문제나오는거임.
            OutputView.printValueOfMenuQuantityPrice(order);
        }
    }

    public int controlPaymentMethod(int tableNumber) {
        OutputView.printTableWillBePayed(tableNumber);
        OutputView.printCardOrCash();
        return getPaymentMethod();
    }
}
