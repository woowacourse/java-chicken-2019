package util;

import domain.Range;
import view.OutputView;

public class InputValidator {
    private static final int DEFAULT_MIN = 0;

    public static boolean isNumberInRange(String input, int begin, int end) {
        try {
            Range range = new Range(begin, end);
            int inputNumber = Integer.parseInt(input);
            return range.verify(inputNumber);
        } catch (NumberFormatException e) {
            OutputView.printNumberError();
            return false;
        }
    }

    public static boolean isNumberInRange(String input, int end) {
        return isNumberInRange(input, DEFAULT_MIN, end);
    }
}
