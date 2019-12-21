package utility;

import view.OutputView;

public class validateUtility {
    public static boolean checkInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (Exception e) {
            OutputView.printNotInteger();
            return false;
        }
    }
}
