/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * InputView.java
 * 입력을 담당하는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package view;

import java.util.Scanner;

import util.InputExceptionHandler;
import util.Message;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputActionNumber() {
        String actionNumber;
        do {
            System.out.println(Message.ACTION_NUMBER_MESSAGE.getMessage());
            actionNumber = scanner.nextLine();
        } while (!InputExceptionHandler.validateActionNumber(actionNumber));
        return Integer.parseInt(actionNumber);
    }

    public static int inputTableNumber() {
        String tableNumber;
        do {
            System.out.println(Message.TABLE_NUMBER_MESSAGE.getMessage());
            tableNumber = scanner.nextLine();
        } while (!InputExceptionHandler.validateTableNumber(tableNumber));
        return Integer.parseInt(tableNumber);
    }

    public static int inputMenuNumber() {
        String menuNumber;
        do {
            System.out.println(Message.MENU_NUMBER_MESSAGE.getMessage());
            menuNumber = scanner.nextLine();
        } while (!InputExceptionHandler.validateMenuNumber(menuNumber));
        return Integer.parseInt(menuNumber);
    }

    public static int inputMenuCount() {
        String menuCount;
        do {
            System.out.println(Message.MENU_COUNT_MESSAGE.getMessage());
            menuCount = scanner.nextLine();
        } while (!InputExceptionHandler.validateMenuCount(menuCount));
        return Integer.parseInt(menuCount);
    }

    public static int inputPayMethod() {
        String payMethod;
        do {
            payMethod = scanner.nextLine();
        } while (!InputExceptionHandler.validatePayMethod(payMethod));
        return Integer.parseInt(payMethod);
    }
}
