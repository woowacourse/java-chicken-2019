/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package view;

import validation.InputValidator;

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
