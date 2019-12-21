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

import domain.TableRepository;

public class InputExceptionHandler {

    public static boolean validateActionNumber(String inputActionNumber) {
        return (isNumber(inputActionNumber)) && (isRangeOfActionNumber(inputActionNumber));
    }

    public static boolean validateTableNumber(String inputTableNumber) {
        return (isNumber(inputTableNumber)) && (isRangeOfTableNumber(inputTableNumber));
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
}
