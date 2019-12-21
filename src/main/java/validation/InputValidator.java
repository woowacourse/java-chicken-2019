package validation;

import domain.MenuRepository;
import domain.TableRepository;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int HUNDRED = 100;

    public static boolean inputMainFunctionValidator(int inputInt) {
        if (inputInt == ONE || inputInt == TWO || inputInt == THREE) {
            return true;
        }
        OutputView.askPutOnlyMainFuncMenuNumber();
        return false;
    }

    public static boolean inputTableNumberValidator(int inputInt) {
        if (TableRepository.hasThisNumberOfTable(inputInt)) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }

    public static boolean inputMenuNumberValidator(int inputInt) {
        if (MenuRepository.hasThisNumberOfMenu(inputInt)) {
            return true;
        }
        OutputView.askReenterNumberInList();
        return false;
    }

    public static boolean inputOrderQuantityValidator(int inputInt) {
        if (inputInt <= ZERO || inputInt >= HUNDRED) {
            OutputView.askReenterOrderQuantity();
            return false;
        }
        return true;
    }
}
