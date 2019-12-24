/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package view;

import domain.Table;
import validation.InputValidator;

import java.util.List;
import java.util.Scanner;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 모든 입력문을 담당하는 클래스입니다.
 * @since : 2019.12.23 월요일
 */
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInputInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            OutputView.askReenterOnlyInteger();
            return getInputInt();
        }
    }

    public static int getMainFunctionNumber() {
        int inputInt;
        do {
            OutputView.printMainFunction();
            inputInt = getInputInt();
        } while (!InputValidator.validateInputMainFunction(inputInt));
        return inputInt;
    }

    public static int getTableNumber() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.validateInputTableNumber(inputInt));
        return inputInt;
    }

    public static int getMenuNumber() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.validateInputMenuNumber(inputInt));
        return inputInt;
    }

    public static int getOrderQuantity() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.validateInputOrderQuantity(inputInt));
        return inputInt;
    }

    public static int getTableNumberForPayment(List<Table> inputOrderedTables) {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.validateInputTableNumber(inputInt) || !InputValidator.isInputTableOrdered(inputInt, inputOrderedTables));
        return inputInt;
    }

    public static int getPaymentMethod() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.validateInputPaymentMethodNumber(inputInt));
        return inputInt;
    }

}
