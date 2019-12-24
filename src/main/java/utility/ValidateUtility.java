package utility;

import view.OutputView;

public class ValidateUtility {
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
        if (menuQuantityNumber > 0 && menuQuantityNumber < 100) {
            return true;
        }
        OutputView.printInputMenuQuantityException();
        return false;
    }

    public static boolean validatePaymentMethod(int paymentMethod) {
        if (paymentMethod == 1 || paymentMethod == 2) {
            return true;
        }
        OutputView.printInputPaymentMethodException();
        return false;

    }
}
