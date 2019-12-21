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
            Table selectedTable = new Table(Integer.parseInt(inputString));
            return TableRepository.tables().contains(selectedTable);
        }
        return false;
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
