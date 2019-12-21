package utils;

import domain.MenuRepository;
import domain.TableRepository;

import java.util.Iterator;
import java.util.List;

/**
 * Validator
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-14
 */

public class Validator {
    public static final int POSITIVE_NUMBER = 1;
    public static final int MAX_ORDER_AMOUNT = 99;

    public int isValidFunctionNumber(int input) {

        if (isNull(input) || (input != 1 && input != 2 && input != 3)) {
            throw new IllegalArgumentException("입력 문자는 1, 2, 3만 가능합니다.");
        }
        return input;
    }

    public int isValidTableNumber(int input) {
        if (isNull(input) || !(TableRepository.isInTable(input))) {
            throw new IllegalArgumentException("메뉴에 있는 번호만 입력이 가능합니다.");
        }
        return input;
    }

    public int isValidMenuNumber(int input) {
        if (isNull(input) || !(MenuRepository.isInMenus(input))) {
            throw new IllegalArgumentException("메뉴에 있는 번호만 입력이 가능합니다.");
        }
        return input;
    }

    public int isValidAmount(int input) {
        if (isNull(input) || isOverMaxOrderAmount(input) || isPositiveNumber(input)) {
            throw new IllegalArgumentException("수량은 1부터 99까지 주문이 가능합니다.");
        }
        return input;
    }

    public int isValidPaymentMethod(int input) {
        if (isNull(input) || (input != 1 && input != 2 && input != 3)) {
            throw new IllegalArgumentException("입력 문자는 1(신용카드), 2(현금)만 가능합니다.");
        }
        return input;
    }

    public boolean isOverMaxOrderAmount(int input) {
        return input > MAX_ORDER_AMOUNT;
    }

    public boolean isPositiveNumber(int input) {
        return input < POSITIVE_NUMBER;
    }

    public boolean isNull(Object input) {
        return input == null;
    }
}
