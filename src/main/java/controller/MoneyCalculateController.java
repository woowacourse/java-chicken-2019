/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.Table;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 결제관련 계산을 컨트롤하는 클래스입니다. (2번 기능에 속함)
 * @since : 2019.12.23 월요일
 */
public class MoneyCalculateController {

    public static Table calculateMoney(int paymentMethod, Table payingTable) {
        return new Table(1); // test
    }

}
