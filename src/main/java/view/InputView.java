/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package view;

import validation.InputValidator;

import java.util.Scanner;

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
        } while (!InputValidator.inputMainFunctionValidator(inputInt));
        return inputInt;
    }

    public static int getTableNumber() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.inputTableNumberValidator(inputInt));
        return inputInt;
    }

    public static int getMenuNumber() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.inputMenuNumberValidator(inputInt));
        return inputInt;
    }

    public static int getOrderQuantity() {
        int inputInt;
        do {
            inputInt = getInputInt();
        } while (!InputValidator.inputOrderQuantityValidator(inputInt));
        return inputInt;
    }



}
