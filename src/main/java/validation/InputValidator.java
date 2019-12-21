package validation;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public static boolean inputMainFunctionValidator(int inputInt) {
        if (inputInt == 1 || inputInt == 2 || inputInt == 3) {
            return true;
        }
        OutputView.askPutOnlyMainFuncMenuNumber();
        return false;
    }

}
