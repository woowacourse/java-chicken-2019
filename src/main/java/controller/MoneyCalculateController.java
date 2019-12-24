/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.Table;
import view.OutputView;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 결제관련 계산을 컨트롤하는 클래스입니다. (2번 기능에 속함)
 * @since : 2019.12.23 월요일
 */
public class MoneyCalculateController {
    private static final double POINT_ZERO_FIVE = 0.05;
    private static final int TWO = 2;


    public static void calculateMoney(int paymentMethod, Table payingTable) {
        int orderedPrice = payingTable.getOrderedPrice();

        if (paymentMethod == TWO) {
            orderedPrice -= (int)(orderedPrice * POINT_ZERO_FIVE);
            OutputView.printTotalPrice(orderedPrice);
            return;
        }
        OutputView.printTotalPrice(orderedPrice);
    }


}
