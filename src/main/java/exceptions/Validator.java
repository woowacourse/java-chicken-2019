package exceptions;

import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import domain.Table;
import domain.TableRepository;

import java.time.temporal.ChronoUnit;

public class Validator {
    private static final String VALID_INPUT_OF_MAIN_UI = "[1-3]";
    private static final String VALID_INPUT_OF_TABLE_NUMBER = "[0-9]+";

    public static void checkInputOfMainUI(String inputOfMainUI) {
        if (!inputOfMainUI.matches(VALID_INPUT_OF_MAIN_UI)) {
            throwException(CustomException.NOT_VALID_INPUT_OF_MAIN_UI);
        }
    }

    public static void checkInputOfTableNumber(String inputOfTableNumber) {
        if (inputOfTableNumber.matches(VALID_INPUT_OF_TABLE_NUMBER)) {
            if (TableRepository.isMatchingTableExist(Integer.parseInt(inputOfTableNumber))) {
                return;
            }
        }
        throwException(CustomException.NOT_VALID_INPUT_OF_TABLE_NUMBER);
    }

    private static void throwException(CustomException e) {
        throw new IllegalArgumentException(e.getErrMessage());
    }
}
