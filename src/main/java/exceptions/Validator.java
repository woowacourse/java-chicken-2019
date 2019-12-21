package exceptions;

import domain.MenuRepository;
import domain.TableRepository;

public class Validator {
    private static final String VALID_INPUT_OF_MAIN_UI = "[1-3]";
    private static final String VALID_INTEGER = "[0-9]+";

    public static void checkInputOfMainUI(String inputOfMainUI) {
        if (!inputOfMainUI.matches(VALID_INPUT_OF_MAIN_UI)) {
            throwException(CustomException.NOT_VALID_INPUT_OF_MAIN_UI);
        }
    }

    public static void checkInputOfTableNumber(String inputOfTableNumber) {
        if (inputOfTableNumber.matches(VALID_INTEGER)) {
            if (TableRepository.isMatchingTableExist(Integer.parseInt(inputOfTableNumber))) {
                return;
            }
        }
        throwException(CustomException.NOT_VALID_INPUT_OF_TABLE_NUMBER);
    }

    public static void checkInputOfMenuNumber(String inputOfMenuNumber) {
        if (inputOfMenuNumber.matches(VALID_INTEGER)) {
            if (MenuRepository.isMatchingMenuExist(Integer.parseInt(inputOfMenuNumber))) {
                return;
            }
        }
        throwException(CustomException.NOT_VALID_INPUT_OF_MENU_NUMBER);
    }

    private static void throwException(CustomException e) {
        throw new IllegalArgumentException(e.getErrMessage());
    }
}
