package utility;

import view.OutputView;

public class ValidateUtility {

    public static final int MENU_INPUT_FLOOR = 0;
    public static final int MENU_INPUT_CEILING = 100;
    public static final int CREDIT_CARD = 1;
    public static final int CASH = 2;

    public static boolean checkInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (Exception e) {
            OutputView.printNotInteger();
            return false;
        }
    }

    public static boolean validateMenuQuantity(int menuQuantityNumber) {
        if (menuQuantityNumber > MENU_INPUT_FLOOR && menuQuantityNumber < MENU_INPUT_CEILING) {
            return true;
        }
        OutputView.printInputMenuQuantityException();
        return false;
    }

    public static boolean validatePaymentMethod(int paymentMethod) {
        if (paymentMethod == CREDIT_CARD || paymentMethod == CASH) {
            return true;
        }
        OutputView.printInputPaymentMethodException();
        return false;

    }
}
