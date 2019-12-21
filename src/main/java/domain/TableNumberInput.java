package domain;

import view.InputView;

import static Util.Utility.isNumeric;

public class TableNumberInput {

    public static int make() {
        String inputString;
        do {
            inputString = InputView.inputTableNumber();
        } while (!isValid(inputString));
        return Integer.parseInt(inputString);
    }

    public static boolean isValid(String inputString) {
        if (isNumeric(inputString)) {
            int selectedNumber = Integer.parseInt(inputString);
            return TableRepository.contain(selectedNumber);
        }
        return false;
    }
}
