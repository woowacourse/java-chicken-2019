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
        return menuQuantityNumber > 0 && menuQuantityNumber < 100;
    }

    public static boolean validatePaymentMethod(int paymentMethod) {
        return paymentMethod == 1 || paymentMethod == 2;
    }
}
