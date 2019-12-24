/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package validation;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.OutputView;

import java.util.List;

import static domain.Quantity.checkOrderQuantity;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 입력의 유효성을 검사하는 클래스입니다.
 * @since : 2019.12.23 월요일
 */
public class InputValidator {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    public static boolean validateInputMainFunction(int inputInt) {
        if (inputInt == ONE || inputInt == TWO || inputInt == THREE) {
            return true;
        }
        OutputView.askPutOnlyMainFuncMenuNumber();
        return false;
    }

    public static boolean validateInputTableNumber(int inputInt) {
        if (TableRepository.hasThisNumberOfTable(inputInt)) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }

    public static boolean validateInputMenuNumber(int inputInt) {
        if (MenuRepository.hasThisNumberOfMenu(inputInt)) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }

    public static boolean validateInputOrderQuantity(int inputInt) {
        if (!checkOrderQuantity(inputInt)) {
            OutputView.askReenterOrderQuantity();
            return false;
        }
        return true;
    }

    public static boolean isInputTableOrdered(int inputInt, List<Table> orderedTables) {
        for (Table table : orderedTables) {
            if (table.isSameTable(inputInt)) {
                return true;
            }
        }
        OutputView.printTableIsNotOrderedYet();
        return false;
    }

    public static boolean validateInputPaymentMethodNumber(int inputInt) {
        if (inputInt == ONE || inputInt == TWO) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }}
