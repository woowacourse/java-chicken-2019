package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFuctionNumber(int maxValue) {
        int input;

        do {
            input = getInteger(Message.INPUT_FUNCTION);
        } while (!checkFunctionNumber(maxValue, input));
        return input;
    }

    private static int getInteger(String message) {
        int input;
        try {
            System.out.println(message);
            input = Integer.parseInt(scanner.nextLine().trim());
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.CONTAINS_CHAR);
            return getInteger(message);
        }
    }

    private static boolean checkFunctionNumber(int maxValue, int inputValue) {
        if (isMinus(inputValue)) {
            System.out.println(ErrorMessage.IS_MINUS);
            return false;
        }
        if (isZero(inputValue)) {
            System.out.println(ErrorMessage.IS_ZERO);
            return false;
        }
        if (!isUnder(inputValue, maxValue)) {
            System.out.println(ErrorMessage.THAT_INPUT_IS_NOT_EXIST);
            return false;
        }
        return true;
    }

    private static boolean isUnder(int inputValue, int maxValue) {
        return (inputValue <= maxValue);
    }

    private static boolean isMinus(int inputValue) {
        return (inputValue < 0);
    }

    private static boolean isZero(int inputValue) {
        return (inputValue == 0);
    }

    public static int inputTableNumber(List<Integer> tableNames) {
        int input;

        do {
            input = getInteger(Message.INPUT_TABLE_NUMBER);
        } while (!checkTableNumber(tableNames, input));
        return input;
    }

    private static boolean checkTableNumber(List<Integer> tableNames, int inputValue) {
        if (isMinus(inputValue)) {
            System.out.println(ErrorMessage.IS_MINUS);
            return false;
        }
        if (isZero(inputValue)) {
            System.out.println(ErrorMessage.IS_ZERO);
            return false;
        }
        if (!tableNames.contains(inputValue)) {
            System.out.println(ErrorMessage.THAT_INPUT_IS_NOT_EXIST);
            return false;
        }
        return true;
    }

    public static int inputMenuNumber(List<Integer> menuNumbers) {
        int input;

        do {
            input = getInteger(Message.INPUT_REGISTER_MENU);
        } while (!checkMenuNumber(menuNumbers, input));
        return input;
    }

    private static boolean checkMenuNumber(List<Integer> menuNumbers, int inputValue) {
        if (isMinus(inputValue)) {
            System.out.println(ErrorMessage.IS_MINUS);
            return false;
        }
        if (isZero(inputValue)) {
            System.out.println(ErrorMessage.IS_ZERO);
            return false;
        }
        if (!menuNumbers.contains(inputValue)) {
            System.out.println(ErrorMessage.THAT_INPUT_IS_NOT_EXIST);
            return false;
        }
        return true;
    }
}
