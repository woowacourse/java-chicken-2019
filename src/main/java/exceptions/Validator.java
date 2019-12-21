package exceptions;

public class Validator {
    private static final String VALID_INPUT_OF_MAIN_UI = "[1-3]";

    public static void checkInputOfMainUI(String inputOfMainUI) {
        if (!inputOfMainUI.matches(VALID_INPUT_OF_MAIN_UI)) {
            throwException(CustomException.NOT_VALID_INPUT_OF_MAIN_UI);
        }
    }

    private static void throwException(CustomException e) {
        throw new IllegalArgumentException(e.getErrMessage());
    }
}
