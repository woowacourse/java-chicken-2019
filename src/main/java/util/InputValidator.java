package util;

import domain.Range;
import view.OutputView;

public class InputValidator {
    private static final int DEFAULT_MIN = 0;

    public static boolean isNumberInRange(String input, int begin, int end) {
        try {
            int inputNumber = Integer.parseInt(input);
            Range range = new Range(begin, end);
            return isRangeVerify(inputNumber, range);
        } catch (NumberFormatException e) {
            OutputView.printNumberError();
            return false;
        }
    }

    public static boolean isNumberInRange(String input, int end) {
        return isNumberInRange(input, DEFAULT_MIN, end);
    }

    private static boolean isRangeVerify(int num, Range range) {
        boolean rangeVerify = range.verify(num);
        if (!rangeVerify) {
            OutputView.printRangeError();
        }
        return rangeVerify;
    }
}
