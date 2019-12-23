/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package validation;

import domain.MenuRepository;
import domain.Quantity;
import domain.TableRepository;
import view.OutputView;

import static domain.Quantity.checkOrderQuantity;

public class InputValidator {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    public static boolean inputMainFunctionValidator(int inputInt) {
        if (inputInt == ONE || inputInt == TWO || inputInt == THREE) {
            return true;
        }
        OutputView.askPutOnlyMainFuncMenuNumber();
        return false;
    }

    public static boolean inputTableNumberValidator(int inputInt) {
        if (TableRepository.hasThisNumberOfTable(inputInt)) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }

    public static boolean inputMenuNumberValidator(int inputInt) {
        if (MenuRepository.hasThisNumberOfMenu(inputInt)) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }

    public static boolean inputOrderQuantityValidator(int inputInt) {
        if (!checkOrderQuantity(inputInt)) {
            OutputView.askReenterOrderQuantity();
            return false;
        }
        return true;
    }
}
