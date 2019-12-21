package Util;

import view.OutputView;

import java.util.regex.Pattern;

public class Utility {

    public static boolean isNumeric(String inputString) {
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
