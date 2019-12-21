package domain;

import view.InputView;

public class TableNumberInput {
    public static int make() {
        String inputString;
        do {
            inputString = InputView.inputTableNumber();
        } while (!isValid(inputString));
        return Integer.parseInt(inputString);
    }
}
