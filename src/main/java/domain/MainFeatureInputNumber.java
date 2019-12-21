package domain;

import Util.Utility;
import view.InputView;
import view.OutputView;

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
        return Utility.isNumeric(inputString) && isFeatureNumber(inputString);
    }

    private static boolean isFeatureNumber(String inputString) {
        int inputNumber = Integer.parseInt(inputString);
        if (inputNumber > MainFeatures.size() || inputNumber < 0) {
            OutputView.printIsNotFeatureNumberError();
            return false;
        }
        return true;
    }
}
