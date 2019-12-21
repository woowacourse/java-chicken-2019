package domain;

import view.InputView;
import view.OutputView;

import java.util.regex.Pattern;

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
            Table inputTable = new Table(Integer.parseInt(inputString));
            return TableRepository.tables().contains(inputTable);
        }
        return false;
    }
}
