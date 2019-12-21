/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * InputExceptionHandler.java
 * 입력 값이 유효한지 검사하는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package util;

import domain.MenuRepository;
import domain.TableRepository;

public class InputExceptionHandler {

    public static boolean validateActionNumber(String inputActionNumber) {
        return (isNumber(inputActionNumber)) && (isRangeOfActionNumber(inputActionNumber));
    }

    public static boolean validateTableNumber(String inputTableNumber) {
        return (isNumber(inputTableNumber)) && (isRangeOfTableNumber(inputTableNumber));
    }

    public static boolean validateMenuNumber(String inputMenuNumber) {
        return (isNumber(inputMenuNumber)) && (isRangeOfMenuNumber(inputMenuNumber));
    }

    public static boolean validateMenuCount(String inputMenuCount) {
        return (isNumber(inputMenuCount)) && (isRangeOfMenuCount(inputMenuCount));
    }

    public static boolean validatePayMethod(String inputPayMethod) {
        return (isNumber(inputPayMethod)) && (isRangeOfPayMethod(inputPayMethod));
    }

    private static boolean isNumber(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println(Message.ACTION_NUMBER_FORMAT_ERROR.getMessage());
            return false;
        }
        return true;
    }

    private static boolean isRangeOfActionNumber(String inputString) {
        int actionNumber = Integer.parseInt(inputString);
        if ((actionNumber == PosRule.ORDER) || (actionNumber == PosRule.PAY)
                || (actionNumber == PosRule.TERMINATION)) {
            return true;
        }
        System.out.println(Message.ACTION_NUMBER_RANGE_ERROR.getMessage());
        return false;
    }

    private static boolean isRangeOfTableNumber(String inputString) {
        if (TableRepository.hasTableNumber(inputString)) {
            return true;
        }
        System.out.println(Message.TABLE_NUMBER_RANGE_ERROR.getMessage());
        return false;
    }

    private static boolean isRangeOfMenuNumber(String inputString) {
        if (MenuRepository.hasMenuNumber(inputString)) {
            return true;
        }
        System.out.println(Message.MENU_NUMBER_RANGE_ERROR.getMessage());
        return false;
    }

    private static boolean isRangeOfMenuCount(String inputString) {
        int menuCount = Integer.parseInt(inputString);
        if ((menuCount > PosRule.ZERO) && (menuCount <= PosRule.MAX_MENU_ORDER_COUNT)) {
            return true;
        }
        System.out.println(Message.MENU_COUNT_RANGE_ERROR.getMessage());
        return false;
    }

    private static boolean isRangeOfPayMethod(String inputString) {
        int payMethod = Integer.parseInt(inputString);
        if ((payMethod == PosRule.CARD) || (payMethod == PosRule.CASH)) {
            return true;
        }
        System.out.println(Message.PAY_METHOD_RANGE_ERROR.getMessage());
        return false;
    }
}
