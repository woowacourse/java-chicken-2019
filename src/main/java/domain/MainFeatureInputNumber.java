package domain;

import view.InputView;
import view.OutputView;

import java.util.regex.Pattern;

public class MainFeatureInputNumber {

    private MainFeatureInputNumber() {
    }

    public static int make() {
        String inputString;
        do {
            inputString = InputView.inputMainFeatureNumber();
        } while (!isValid(inputString));
        return Integer.parseInt(inputString);
    }

    private static boolean isValid(String inputString) {
        return isNumeric(inputString) && isFeatureNumber(inputString);
    }

    private static boolean isNumeric(String inputString) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (inputString == null) {
            return false;
        }
        if (!pattern.matcher(inputString).matches()) {
            OutputView.printIsNotNumberError();
            return false;
        }
        return true;
    }
}
