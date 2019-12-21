package exceptions;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.regex.Pattern;

public class Validator {
    private static final String VALID_INPUT_OF_MAIN_UI = "[1-3]";
    private static final String VALID_INTEGER = "[0-9]+";
    private static final String VALID_MENU_QUANTITY = "^[1-9][0-9]?";

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

    public static void checkInputOfMenuQuantity(String inputOfMenuQuantity) {
        if (!inputOfMenuQuantity.matches(VALID_MENU_QUANTITY)) {
            throwException(CustomException.NOT_VALID_INPUT_OF_MENU_QUANTITY);
        }
    }

    public static void checkQuantityExceed(Table table, Menu menu, int menuQuantity) {
        if (!table.canAddMenuQuantity(menu, menuQuantity)) {
            throwException(CustomException.OVER_MAX_MENU_QUANTITY);
        }
    }

    public static void checkAlreadyFullyOrdered(Table table, Menu menu) {
        if (table.IsAlreadyFullyOrdered(menu)) {
            throwException(CustomException.ALREADY_FULLY_ORDERED_MENU);
        }
    }

    private static void throwException(CustomException e) {
        throw new IllegalArgumentException(e.getErrMessage());
    }
}
